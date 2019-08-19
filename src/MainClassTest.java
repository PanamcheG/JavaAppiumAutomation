import org.junit.Test;

public class MainClassTest
{
    @Test
    public void testGetClassString (){
        if ((MainClass.getClassString().contains("Hello")) || (MainClass.getClassString().contains("hello"))) {
            System.out.println("Test successful!");
        }
            else    {
                System.out.println("Didn't find required sequence!");
            }
    }
}
