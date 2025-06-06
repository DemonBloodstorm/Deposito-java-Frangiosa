import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Benvenuto nella Battaglia dei Comandanti!");
        System.out.print("Inserisci il nome del tuo comandante: ");
        String nomeComandante = scanner.nextLine();
      
     
        // inizializza il budget del giocatore
        Comandante giocatore = new Comandante(nomeComandante, 500);
        Comandante IA = new Comandante("IA", 500);

        List<Combattente> esercitoIA = Battaglia.generaEsercitoNemico(IA.getBudget());
        for (Combattente c : esercitoIA) {
            IA.addSoldato(c);// CORRETTO: i soldati vanno al comandante IA
        }

        List<Combattente> esercitoGiocatore = Battaglia.generaEsercitoDaInput(scanner, giocatore.getBudget(),nomeComandante);
        for (Combattente c : esercitoGiocatore) {
            giocatore.addSoldato(c);
        }

        // Stampa gli eserciti
        boolean haVintoGiocatore = Battaglia.iniziaBattaglia(giocatore, IA);

        if (haVintoGiocatore) {
            System.out.println(nomeComandante + "ha vinto la battaglia!");
        } else {
            System.out.println("L'IA ha vinto la battaglia!");
        }

    }
}