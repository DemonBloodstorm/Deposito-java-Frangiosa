
import java.util.Scanner; // import il scanner

public class ProvaScanner{
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);//Creazione di un ogetto Scanner
        System.out.println("Enter username: ");
        String userName = myObj.nextLine();// lettura dell'input
        System.out.println("Username is: "+ userName);
        myObj.close();
    }// Output user input
} 