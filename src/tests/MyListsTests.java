package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class MyListsTests extends CoreTestCase
{
    @Test
    public void testSaveFirstArticleToMyList()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();
        String nameOfFolder = "Learning programming";
        ArticlePageObject.addArticleToMyList(article_title);
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.clickMyLists();

        MyListsPageObject MyListsPageObject = new MyListsPageObject(driver);
        MyListsPageObject.openFolderByName(nameOfFolder);
        MyListsPageObject.swipeByArticleToDelete(article_title);
    }

    @Test
    public void testExerciseFive() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Canada");
        SearchPageObject.clickByArticleWithSubstring("Country in North America");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title_one_before_deletion = ArticlePageObject.getArticleTitle();
        String nameOfFolder = "Exercise 5 folder";
        ArticlePageObject.addArticleToMyList(nameOfFolder);
        ArticlePageObject.closeArticle();

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        String article_title_two = ArticlePageObject.getArticleTitle();
        ArticlePageObject.addAnotherArticleToMyList(nameOfFolder);
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.clickMyLists();

        MyListsPageObject MyListsPageObject = new MyListsPageObject(driver);
        MyListsPageObject.openFolderByName(nameOfFolder);
        MyListsPageObject.swipeByArticleToDelete(article_title_two);
        SearchPageObject.clickByArticleWithSubstring("Country in North America");
        String article_title_one_after_deletion = ArticlePageObject.getArticleTitle();

        assertEquals(
                "Article title has been changed after article deletion",
                article_title_one_before_deletion,
                article_title_one_after_deletion);
    }
}
