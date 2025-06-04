import java.util.ArrayList;
import java.util.Scanner;

public class Azienda {

    static class Dipendente { // classe dipendente che contiene nome, dipartimento e stipendio
        String nome, dipartimento;
        int stipendio;

        public Dipendente(String nome, String dipartimento, int stipendio) { // costruttore dipendente che prende nome, dipartimento e stipendio come parametri e inizializza i loro valori
            this.nome = nome;
            this.dipartimento = dipartimento;
            this.stipendio = stipendio;
        }

        @Override
        public String toString() { // tostring che ordina i dipendenti in base al nome, dipartimento e stipendio
            return nome + " " + dipartimento + " " + stipendio;
        }
    }

    static class CreaDipendente { // classe creadipendente che prende lista dipendenti e scanner come parametri e crea un nuovo dipendente
        public void creaDipendente(ArrayList<Dipendente> listaDipendenti, Scanner sc) {
            System.out.print("Inserisci il nome del dipendente: ");
            String nome = sc.nextLine();
            System.out.print("Inserisci il dipartimento del dipendente: ");
            String dipartimento = sc.nextLine();
            System.out.print("Inserisci lo stipendio del dipendente: ");
            int stipendio = sc.nextInt();
            sc.nextLine(); // pulisci newline
            listaDipendenti.add(new Dipendente(nome, dipartimento, stipendio));
        }
    }


    static class MostraDipendenti { // classe MostraDipendenti che prende lista dipendenti come parametro e mostra tutti i dipendenti
        public void mostraDipendenti(ArrayList<Dipendente> listaDipendenti) {
            if (listaDipendenti.isEmpty()) {
                System.out.println("Nessun dipendente presente.");
            } else {
                for (Dipendente dip : listaDipendenti) {
                    System.out.println(dip);
                }
            }
        }
    }

    static class RimuoviDipendente {// classe RimuoviDipendente che prende lista dipendenti e nome come parametri e rimuove il dipendente con il nome specificato
        public void rimuoviDipendente(ArrayList<Dipendente> listaDipendenti, String nome) {
            for (int i = 0; i < listaDipendenti.size(); i++) {
                if (listaDipendenti.get(i).nome.equalsIgnoreCase(nome)) {
                    listaDipendenti.remove(i);
                    System.out.println("Dipendente rimosso.");
                    return;
                }
            }
            System.out.println("Dipendente non trovato.");
        }
    }

    // Main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Dipendente> listaDipendenti = new ArrayList<>();

        CreaDipendente crea = new CreaDipendente();
        MostraDipendenti mostra = new MostraDipendenti();
        RimuoviDipendente rimuovi = new RimuoviDipendente();

        boolean continua = true;
        while (continua) {
            System.out.println("\n1. Aggiungi dipendente");
            System.out.println("2. Mostra dipendenti");
            System.out.println("3. Rimuovi dipendente");
            System.out.println("4. Esci");
            System.out.print("Scelta: ");
            int scelta = sc.nextInt();
            sc.nextLine(); // consuma newline

            switch (scelta) {
                case 1:
                    crea.creaDipendente(listaDipendenti, sc);
                    break;
                case 2:
                    mostra.mostraDipendenti(listaDipendenti);
                    break;
                case 3:
                    System.out.print("Inserisci il nome del dipendente da rimuovere: ");
                    String nome = sc.nextLine();
                    rimuovi.rimuoviDipendente(listaDipendenti, nome);
                    break;
                case 4:
                    continua = false;
                    System.out.println("Uscita dal programma.");
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }
        }

        sc.close();
    }
}
