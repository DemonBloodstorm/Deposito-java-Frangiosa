import java.util.Scanner;

public class Scaffale {

    static class Libro { // Classe Libro che contiene titolo, autore, prezzo e codice
        String titolo;
        String autore;
        double prezzo;
        int codice;

        public Libro(String titolo, String autore, double prezzo, int codice) { // Costruttore che inizializza i campi
            this.titolo = titolo;
            this.autore = autore;
            this.prezzo = prezzo;
            this.codice = codice;
        }

        @Override
        public String toString() { // Metodo toString che restituisce una stringa con i dati del libro
            return "Titolo: " + titolo + ", Autore: " + autore + ", Prezzo: €" + prezzo + ", Codice: " + codice;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Libro[] scaffale = new Libro[10]; // Array di oggetti Libro

        boolean aggiunto = false; // Flag per verificare se è stato aggiunto un libro

        for (int i = 0; i < scaffale.length; i++) {
            if (scaffale[i] == null) {
                System.out.print("Inserisci titolo: ");
                String titolo = sc.nextLine();

                System.out.print("Inserisci autore: ");
                String autore = sc.nextLine();

                System.out.print("Inserisci prezzo: ");
                double prezzo = sc.nextDouble();

                System.out.print("Inserisci codice numerico: ");
                int codice = sc.nextInt();
                sc.nextLine(); // Consuma newline

                scaffale[i] = new Libro(titolo, autore, prezzo, codice); // Aggiunge libro all'array
                aggiunto = true;
                System.out.println("Libro aggiunto nello scaffale in posizione " + (i + 1));
                break;
            }
        }

        if (!aggiunto) { // Se non è stato aggiunto un libro
            System.out.println("Scaffale pieno, impossibile aggiungere altri libri.");
        }

        // Visualizza tutti i libri nello scaffale
        System.out.println("\nLibri presenti nello scaffale:");
        for (int i = 0; i < scaffale.length; i++) {
            if (scaffale[i] != null) {
                System.out.println((i + 1) + ". " + scaffale[i]);
            }
        }

        sc.close();
    }
}
