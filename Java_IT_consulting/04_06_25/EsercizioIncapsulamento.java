import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioIncapsulamento {

    // Classe interna per rappresentare un ingrediente con nome e prezzo
    static class Ingrediente {
        String nome;
        double prezzo;

        // Costruttore
        public Ingrediente(String nome, double prezzo) {
            this.nome = nome;
            this.prezzo = prezzo;
        }

        // Metodo toString per stampare gli ingredienti privati
        @Override
        public String toString() {
            return nome + " " + prezzo + " euro";
        }
    }

    // Classe per rappresentare un piatto speciale
    static class PiattoSpeciale {
        private ArrayList<Ingrediente> ingredientiPrivati;
        public ArrayList<Ingrediente> ingredientiPublici;

        public PiattoSpeciale() {
            ingredientiPrivati = new ArrayList<>();
            ingredientiPublici = new ArrayList<>();

            // Aggiungi ingredienti predefiniti
            ingredientiPrivati.add(new Ingrediente("Panino di sesamo", 1.00));
            ingredientiPrivati.add(new Ingrediente("Panino normale", 1.00));
            ingredientiPrivati.add(new Ingrediente("Salame", 2.00));
            ingredientiPrivati.add(new Ingrediente("Prosciutto crudo", 1.00));
        }
        
        // Metodo per mostrare gli ingredienti privati
        public void mostraIngredientiPrivati() {
            System.out.println("Ingredienti disponibili:");
            for (int i = 0; i < ingredientiPrivati.size(); i++) {
                System.out.println((i + 1) + ". " + ingredientiPrivati.get(i));
            }
        }

        // Metodo per aggiungere un ingrediente al piatto
        public void aggiungiIngrediente(int indice) {
            if (indice >= 0 && indice < ingredientiPrivati.size()) {
                Ingrediente ingr = ingredientiPrivati.get(indice);
                ingredientiPublici.add(ingr);
                System.out.println("Hai aggiunto: " + ingr.nome);
            } else {
                System.out.println("Numero non valido.");
            }
        }

        // Metodo per mostrare gli ingredienti scelti
        public void mostraIngredientiScelti() {
            System.out.println("\nIngredienti scelti:");
            double totale = 0;
            for (Ingrediente ingr : ingredientiPublici) {
                System.out.println(ingr);
                totale += ingr.prezzo;
            }
            System.out.println("Totale: " + totale+" euro");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PiattoSpeciale ps = new PiattoSpeciale();
        double prezzoFinale;

        while (true) {
            ps.mostraIngredientiPrivati();// Mostra gli ingredienti privati
            System.out.println("Scegli un ingrediente (numero) oppure digita 0 per terminare:");
            int scelta;

            try {// Gestione dell'input
                scelta = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Inserisci un numero valido.");
                continue;
            }

            if (scelta == 0) {
                break;
            } else {
                ps.aggiungiIngrediente(scelta - 1); // indice base 0
            }
        }
        ps.mostraIngredientiScelti();

        sc.close();
    }
}
