import org.junit.Test;

public class MainClassTest
{
    @Test
    public void testGetLocalNumber (){
        if (MainClass.getLocalNumber() == 14) {
            System.out.println("Test successful!");
        }
            else    {
                System.out.println("Local number is not 14!");
            }
    }
}
