import java.util.Scanner;
import org.junit.Test;


public class AppInterfaceTest {


    @Test
    public int testAppInterface() {
        Scanner reader = new Scanner(System.in);
        System.out.println("enter your name: ");
        int input = reader.nextInt();


       if (input > 0 )  {
            System.out.println("please enter a real name: ");
            input = reader.nextInt();
        }

       	 reader.close();
         return input;
    }
}