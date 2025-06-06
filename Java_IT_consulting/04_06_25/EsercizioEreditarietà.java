import java.util.ArrayList;
import java.util.Scanner;

class Utente { // classe Utente con nome, email e soldi
    private String nome;
    private String email;
    private float soldi;

    public Utente(String nome, String email) {// costruttore Utente che prende in input nome e email
        this.nome = nome;
        this.email = email;
        this.soldi = (float) (Math.random() * 1000);
    }

    public void stampaDati() { // metodo per stampare i dati dell'utente
        System.out.println("----- Dati Utente -----");
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.printf("Credito: %.2f euro\n", soldi);
    }
}

class Ristorante { // classe Ristorante con lista di piatti e valutazioni
    static ArrayList<String> piatti = new ArrayList<>();
    static ArrayList<String> valutazioni = new ArrayList<>();

    public void aggiungiPiatto(String piatto) { // metodo per aggiungere un piatto alla lista dei piatti
        piatti.add(piatto);
    }

    public void aggiungiValutazione(String valutazione) { // metodo per aggiungere una valutazione alla lista delle valutazioni
        valutazioni.add(valutazione);
    }

    public void stampaPiatti() { // metodo per stampare la lista dei piatti
        System.out.println("----- Piatti Disponibili -----");
        for (int i = 0; i < piatti.size(); i++) {
            System.out.println((i + 1) + ". " + piatti.get(i));
        }
    }

    public void stampaValutazioni() { // metodo per stampare la lista delle valutazioni
        System.out.println("----- Valutazioni -----");
        for (int i = 0; i < valutazioni.size(); i++) {
            System.out.println((i + 1) + ". " + valutazioni.get(i));
        }
    }
}

class Chef extends Utente { // classe Chef che eredita da Utente e ha un riferimento al ristorante
    private Ristorante ristorante;

    public Chef(String nome, String email, Ristorante ristorante) { // costruttore Chef che prende in input nome, email e ristorante
        super(nome, email);
        this.ristorante = ristorante;
    }

    public void aggiungiPiatto(String piatto) { // metodo per aggiungere un piatto al ristorante
        ristorante.aggiungiPiatto(piatto);
    }
}

class Critico extends Utente { // classe Critico che eredita da Utente e ha un riferimento al ristorante
    private Ristorante ristorante;

    public Critico(String nome, String email, Ristorante ristorante) { // costruttore Critico che prende in input nome, email e ristorante
        super(nome, email);
        this.ristorante = ristorante;
    }

    public void aggiungiValutazione(String valutazione) { // metodo per aggiungere una valutazione al ristorante
        ristorante.aggiungiValutazione(valutazione);
    }
}

public class EsercizioEreditarietà { // classe principale del programma che gestisce l'interazione con l'utente
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Utente utenteCorrente = null;
        Ristorante ristorante = new Ristorante();
        // menu visualizzato
        while (true) {
            System.out.println("\n---- MENU RISTORANTE ----");
            System.out.println("1. Crea nuovo utente");
            System.out.println("2. Stampa dati utente");
            System.out.println("3. Diventa chef (aggiungi un piatto)");
            System.out.println("4. Diventa critico (aggiungi una valutazione)");
            System.out.println("5. Visualizza piatti e valutazioni");
            System.out.println("6. Esci");
            System.out.print("Scelta: ");
            int scelta = input.nextInt();
            input.nextLine(); // pulizia buffer

            switch (scelta) {// Scelta dell'utente per eseguire un'azione
                case 1: { // Creazione di un nuovo utente
                    System.out.print("Inserisci il nome: ");
                    String nome = input.nextLine();
                    System.out.print("Inserisci l'email: ");
                    String email = input.nextLine();
                    utenteCorrente = new Utente(nome, email);
                    System.out.println("Utente creato con successo!");
                    break;
                }
                case 2: { // Stampa dei dati dell'utente
                    if (utenteCorrente != null) {
                        utenteCorrente.stampaDati();
                    } else {
                        System.out.println("Nessun utente creato!");
                    }
                    break;
                }
                case 3: { // Diventa chef e aggiungi un piatto
                    if (utenteCorrente != null) {
                        System.out.print("Inserisci il nome del piatto: ");
                        String piatto = input.nextLine();
                        Chef chef = new Chef("Chef " + utenteCorrente.getClass().getSimpleName(), "chef@mail.com", ristorante);
                        chef.aggiungiPiatto(piatto);
                        System.out.println("Piatto aggiunto!");
                    } else {
                        System.out.println("Crea prima un utente!");
                    }
                    break;
                }
                case 4: { // Diventa critico e aggiungi una valutazione
                    if (utenteCorrente != null) {
                        System.out.print("Inserisci la valutazione: ");
                        String valutazione = input.nextLine();
                        Critico critico = new Critico("Critico " + utenteCorrente.getClass().getSimpleName(), "critico@mail.com", ristorante);
                        critico.aggiungiValutazione(valutazione);
                        System.out.println("Valutazione aggiunta!");
                    } else {
                        System.out.println("Crea prima un utente!");
                    }
                    break;
                }
                case 5: { // Visualizza piatti e valutazioni
                    ristorante.stampaPiatti();
                    ristorante.stampaValutazioni();
                    break;
                }
                case 6: { // Esci dal programma
                    System.out.println("Uscita dal programma. Arrivederci!");
                    input.close();
                    return;
                }
                default: // L'utente è una capra e non sa cliccare un numero tra 1 e 6
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
    }
}
