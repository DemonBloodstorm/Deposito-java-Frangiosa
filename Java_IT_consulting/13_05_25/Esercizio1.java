
import java.util.Scanner; // importo lo scanner

public class Esercizio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // inizializzo lo scanner
        int i;
        String s;
        boolean b;
        double d;
        // Richiedo all'utente di immettere un intero da tastiera
        System.out.println("Inserisci un numero intero: ");
        i = sc.nextInt();

        sc.nextLine(); // metto un sc.nextLine() per svuotare lo scanner dal newline

        // Richiedo all'utente di immettere una stringa da tastiera
        System.out.println("Inserisci un carattere o una parola: ");
        s = sc.nextLine();
        // Richiedo all'utente di immettere un boolean da tastiera
        System.out.println("Inserisci True o False: ");// attenzione a non mettere falso, vero, 0 o 1!
        b = sc.nextBoolean();
        // Richiedo all'utente di immettere un double da tastiera
        System.out.println("Inserisci un numero con la virgola: ");
        d = sc.nextDouble();
        // Stampo tutti i dati
        System.out.println("Int: " + i + " String: " + s + " boolean: " + b + " Double: " + d);
        sc.close(); // Chiudo lo scanner
    }
}
