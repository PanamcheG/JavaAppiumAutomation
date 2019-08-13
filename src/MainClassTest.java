import org.junit.Test;

public class MainClassTest
{
    @Test
    public void testGetClassNumber (){
        if (MainClass.getClassNumber() > 45) {
            System.out.println("Test successful!");
        }
            else    {
                System.out.println("Class number is less that 45!");
            }
    }
}
