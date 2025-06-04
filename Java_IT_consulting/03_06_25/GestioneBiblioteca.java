import java.util.ArrayList;
import java.util.Scanner;

public class GestioneBiblioteca {

    static class User { // classe per gestire l'utente
        String userName, password;

        User(String userName, String password) { // costruttore per l'utente
            this.userName = userName;
            this.password = password;
        }
    }
    
    static boolean login() { // metodo per effettuare il login
        Scanner sc = new Scanner(System.in);
        System.out.println("Benvenuto!");
        System.out.print("Inserisci il tuo nome: ");
        String name = sc.nextLine();
        System.out.print("Inserisci la tua password: ");
        String pwd = sc.nextLine();
        User user = new User(name, pwd);

        if (user.userName.equals("admin") && user.password.equals("admin")) {
            System.out.println("Accesso effettuato!");
            return true; // login effettuato
        } else {
            System.out.println("Accesso negato!");
            return false; // login negato
        }
    }

    static class Book { // classe per gestire il libro
        String title, author;
        boolean isAvailable;

        Book(String title, String author) { // costruttore per creare un libro
            this.title = title;
            this.author = author;
            this.isAvailable = true;
        }

        void displayBookInfo() { // metodo per visualizzare le informazioni del libro
            System.out.println("Titolo: " + title);
            System.out.println("Autore: " + author);
            System.out.println("Disponibilità: " + (isAvailable ? "Disponibile" : "Non disponibile"));
        }
    }

    static class Library { // classe per gestire la biblioteca
        ArrayList<Book> books = new ArrayList<>();

        void addBook(Book b) { // metodo per aggiungere un libro alla biblioteca
            books.add(b);
        }

        void displayBooks() { // metodo per visualizzare tutti i libri
            for (Book b : books) {
                b.displayBookInfo();
                System.out.println();
            }
        }

        void borrowBook(String title) { // metodo per prendere in prestito un libro
            for (Book b : books) {
                if (b.title.equalsIgnoreCase(title)) {
                    if (b.isAvailable) {
                        b.isAvailable = false;
                        System.out.println("Hai preso in prestito: " + b.title);
                    } else {
                        System.out.println("Il libro è già stato preso.");
                    }
                    return;
                }
            }
            System.out.println("Libro non trovato: " + title); 
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library biblioteca = new Library();
        // Aggiungi libri alla biblioteca
        biblioteca.addBook(new Book("Il Signore degli Anelli", "J.R.R. Tolkien"));
        biblioteca.addBook(new Book("1984", "George Orwell"));
        biblioteca.addBook(new Book("Harry Potter", "J.K. Rowling"));
        // Login
        if (login()) {
            // Menu principale
            while (true) {
                System.out.println("\n--- Menu Biblioteca ---");
                System.out.println("1. Visualizza tutti i libri");
                System.out.println("2. Prendi in prestito un libro");
                System.out.println("3. Esci");
                System.out.print("Scelta: ");
                int scelta = sc.nextInt();
                sc.nextLine(); // consuma newline

                switch (scelta) {//scelta del menu
                    case 1:
                        biblioteca.displayBooks();
                        break;
                    case 2:
                        System.out.print("Inserisci il titolo del libro: ");
                        String titolo = sc.nextLine();
                        biblioteca.borrowBook(titolo);
                        break;
                    case 3:
                        System.out.println("Chiusura programma.");
                        sc.close();
                        return;
                    default:
                        System.out.println("Scelta non valida.");
                }
            }
        }
    }
}
