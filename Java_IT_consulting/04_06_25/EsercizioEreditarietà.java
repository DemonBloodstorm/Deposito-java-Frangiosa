import java.util.ArrayList;
import java.util.Scanner;

class Utente {
    private String nome;
    private String email;
    private float soldi;

    public Utente(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.soldi = (float) (Math.random() * 1000);
    }

    public void stampaDati() {
        System.out.println("----- Dati Utente -----");
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.printf("Credito: %.2f €\n", soldi);
    }
}

public class EsercizioEreditarietà {

    static ArrayList<String> piatti = new ArrayList<>();
    static ArrayList<String> valutazioni = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Utente utenteCorrente = null;

        while (true) {
            System.out.println("\n---- MENU RISTORANTE ----");
            System.out.println("1. Crea nuovo utente");
            System.out.println("2. Stampa dati utente");
            System.out.println("3. Esci");
            System.out.print("Scelta: ");
            int scelta = input.nextInt();
            input.nextLine(); // pulizia buffer

            switch (scelta) {
                case 1 -> {
                    System.out.print("Inserisci il nome: ");
                    String nome = input.nextLine();
                    System.out.print("Inserisci l'email: ");
                    String email = input.nextLine();
                    utenteCorrente = new Utente(nome, email);
                    System.out.println("Utente creato con successo!");
                }
                case 2 -> {
                    if (utenteCorrente != null) {
                        utenteCorrente.stampaDati();
                    } else {
                        System.out.println(" Nessun utente creato!");
                    }
                }
                case 3 -> {
                    System.out.println("Uscita dal programma. Arrivederci!");
                    input.close();
                    return;
                }
                default -> System.out.println("Scelta non valida. Riprova.");
            }
        }
    }
}
