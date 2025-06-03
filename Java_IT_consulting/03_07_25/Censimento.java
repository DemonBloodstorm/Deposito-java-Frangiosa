
import java.util.Scanner;

public class Censimento {

    static class Persona {
        Scanner sc = new Scanner(System.in);
        String[] citta = new String[10];

        void aggiungiPersona() { // aggiunge la persona alla posizione i
            for (int i = 0; i < 10; i++) {
                System.out.print("Inserisci nome: ");
                String nome = sc.nextLine();

                System.out.print("Inserisci età: ");
                int eta = sc.nextInt();
                sc.nextLine(); // consuma newline

                citta[i] = nome + " " + eta + " anni, Benevento";
            }
        }

        void mostraPersona() { // mostra la persona nella posizione i
            System.out.println("Chi vuoi vedere?");
            System.out.print("Inserisci numero tra 1 e 10: ");
            int scelta = sc.nextInt();
            sc.nextLine(); // consuma newline

            if (scelta >= 1 && scelta <= 10) {
                System.out.println(citta[scelta - 1]);
            } else {
                System.out.println("Scelta non valida.");
            }
        }
    }

    public static void main(String[] args) {
        Persona p = new Persona();
        p.aggiungiPersona(); // aggiunge 10 persone
        p.mostraPersona(); // mostra una persona
    }
}
