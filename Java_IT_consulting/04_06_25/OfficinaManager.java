
import java.util.ArrayList;
import java.util.Scanner;

public class OfficinaManager {

    static class Auto {
        String targa, modello;

        public Auto(String targa, String modello) {
            this.targa = targa;
            this.modello = modello;
        }
    }

    static class Officina { // classe Officina
        ArrayList<Auto> listaAuto = new ArrayList<>(); // ArrayList di oggetti Auto

        public void aggiungiAuto(Auto a) {// metodo aggiungiAuto che accetta un oggetto Auto
            listaAuto.add(a);
        }

        public void stampaAuto() { // metodo stampaAuto che stampa l'elenco delle auto presenti nell'officina
            if (listaAuto.isEmpty()) {
                System.out.println("Nessuna auto presente."); // se l'ArrayList è vuoto
            } else {
                System.out.println("Elenco auto presenti:"); // altrimenti stampa l'elenco delle auto
                for (Auto a : listaAuto) {
                    System.out.println("- " + a.targa + " | " + a.modello); // per ogni oggetto Auto nell'ArrayList stampa la targa e il modello
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);// crea un oggetto Scanner per leggere l'input dell'utente
        Officina o = new Officina(); // crea un oggetto Officina
        int scelta;

        do {
            // menu
            System.out.println("\nMenu:");
            System.out.println("1. Aggiungi auto");
            System.out.println("2. Stampa elenco auto");
            System.out.println("3. Esci");
            System.out.print("Scelta: ");
            scelta = sc.nextInt(); // legge l'input dell'utente

            // switch case per la scelta dell'utente
            switch (scelta) {
                case 1:
                    System.out.print("Inserisci targa: ");
                    String targa = sc.next();
                    System.out.print("Inserisci modello: ");
                    String modello = sc.next();
                    Auto nuova = new Auto(targa, modello);
                    o.aggiungiAuto(nuova);
                    break;

                case 2:
                    o.stampaAuto();
                    break;

                case 3:
                    System.out.println("Uscita dal programma.");
                    break;

                default:
                    System.out.println("Scelta non valida.");
            }

        } while (scelta != 3);// finchè l'utente non sceglie di uscire

        sc.close();// chiude lo scanner
    }
}
