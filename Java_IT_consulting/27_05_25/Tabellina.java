//Chiedete in imput all'utente un numero compreso tra 1 e 10 e stampate la sua tabellina
import java.util.Scanner;

public class Tabellina {    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);// Crea uno Scanner per leggere l'input dell'utente
        int numero;

        System.out.print("Inserisci il numero di cui vuoi calcolare la tabellina: ");
        numero = sc.nextInt();
        if (numero < 1 || numero > 10) {
            System.out.println("Il numero deve essere compreso tra 1 e 10.");
            sc.close(); // chiudo lo scanner
            return; // esce dal programma se il numero non è valido
        }
        System.out.println("Tabellina del " + numero + ":");

        // Stampa la tabellina del numero inserito
        for (int i = 0; i<=10; i++) {
            System.out.println(numero +" * "+ i +" = "+ numero * i);
            }
        sc.close();// chiudo lo scanner
    }
}