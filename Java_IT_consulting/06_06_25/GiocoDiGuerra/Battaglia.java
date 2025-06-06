import java.util.*;

public class Battaglia {

    private static Random rand = new Random();
    
    // Genera esercito nemico casuale
   public static List<Combattente> generaEsercitoNemico(int budget) {
    List<Combattente> esercito = new ArrayList<>();
    System.err.println("== GENERAZIONE ESERCITO CPU ==");

    while (true) {
        List<Combattente> opzioni = new ArrayList<>();
        if (budget >= 60) opzioni.add(new Arciere("AI Arciere"));
        if (budget >= 75) opzioni.add(new Lanciere("AI Lanciere"));
        if (budget >= 100) opzioni.add(new Cavaliere("AI Cavaliere"));

        if (opzioni.isEmpty()) break;

        Combattente c = opzioni.get(rand.nextInt(opzioni.size()));
        esercito.add(c);
        budget -= c.getCosto();
    }

    return esercito;
}
    // Esercito da input per il giocatore
    public static List<Combattente> generaEsercitoDaInput(Scanner input, int budget,String nomeComandante) {
        List<Combattente> esercito = new ArrayList<>();
        int restante = budget;

        System.out.println("== CREA IL TUO ESERCITO ==");
        while (restante >= 50) {
            System.out.println("Budget disponibile: " + restante);
            System.out.println("1. Arciere (60 monete) | 2. Lanciere (75 monete) | 3. Cavaliere (100 monete) | 0. Fine Arruolamento");
            System.out.print("Scelta: ");
            int scelta = input.nextInt();
            Combattente c = null;

            switch (scelta) {
                case 1:
                    c = new Arciere("PLAYER Arciere");
                    break;
                case 2:
                    c = new Lanciere("PLAYER Lanciere");
                    break;
                case 3:
                    c = new Cavaliere("PLAYER Cavaliere");
                    break;
                  default: 
                System.out.println("scelta non valida");
            }

            if (scelta == 0)
                break;

            if (c != null && c.getCosto() <= restante) {
                esercito.add(c);
                restante -= c.getCosto();
                System.out.println(nomeComandante + " ha arruolato: " + c.getDescrizione());
            } else if (c != null) {
                System.out.println("Budget insufficiente!");
            }
        }

        return esercito;
    }

    // Logica battaglia
    public static boolean iniziaBattaglia(Comandante c1, Comandante c2) {
        List<Combattente> esercito1 = new ArrayList<>(c1.getEsercito());
        List<Combattente> esercito2 = new ArrayList<>(c2.getEsercito());

        int turni = 0;
        int uccisiDaC1 = 0;
        int uccisiDaC2 = 0;

        System.out.println("\n== INIZIO BATTAGLIA ==");

        while (!esercito1.isEmpty() && !esercito2.isEmpty()) {
            System.out.println("Turno: " + turni);
            turni++;

            Combattente a = esercito1.get(0);
            Combattente b = esercito2.get(0);

            int dannoA = a.attacca();
            int dannoB = b.attacca();

            b.riceviDanno(dannoA);
            a.riceviDanno(dannoB);

            System.out.println(a.getDescrizione() + " infligge " + dannoA + " a " + b.getDescrizione());
            System.out.println(b.getDescrizione() + " infligge " + dannoB + " a " + a.getDescrizione());

            if (!a.èVivo()) {
                esercito1.remove(0);
                uccisiDaC2++;
                System.out.println(a.getDescrizione() + " è stato sconfitto!");
            }
            if (!b.èVivo()) {
                esercito2.remove(0);
                uccisiDaC1++;
                System.out.println(b.getDescrizione() + " è stato sconfitto!");
            }

            System.out.println("----");
        }

        int guad1 = uccisiDaC1 * 20 + (esercito1.isEmpty() ? 0 : 10);
        int guad2 = uccisiDaC2 * 20 + (esercito2.isEmpty() ? 0 : 10);


        System.out.println("== RISULTATO ==");
        System.out.println(c1.getNome() + " guadagna " + guad1 + " monete");
        System.out.println(c2.getNome() + " guadagna " + guad2 + " monete");

        return !esercito1.isEmpty(); // true se il comandante 1 ha vinto
    }
}
