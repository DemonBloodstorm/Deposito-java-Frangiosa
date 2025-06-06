import java.util.ArrayList;
import java.util.Scanner;

// Classe base Animale
class Animale {
    private String nome;
    private int eta;

    public Animale(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    void faiVerso() {
        System.out.println("Verso generico...");
    }

    void setNome(String nome) {
        this.nome = nome;
    }

    String getNome() {
        return nome;
    }

    void setEta(int eta) {
        this.eta = eta;
    }

    int getEta() {
        return eta;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Età: " + eta;
    }
}

// Sottoclasse Cane
class Cane extends Animale {
    public Cane(String nome, int eta) {
        super(nome, eta);
    }

    @Override
    void faiVerso() {
        System.out.println("Bau!");
    }
}

// Sottoclasse Gatto
class Gatto extends Animale {
    public Gatto(String nome, int eta) {
        super(nome, eta);
    }

    @Override
    void faiVerso() {
        System.out.println("Miao!");
    }
}

// Sottoclasse Uccello
class Uccello extends Animale {
    public Uccello(String nome, int eta) {
        super(nome, eta);
    }

    @Override
    void faiVerso() {
        System.out.println("Pio!");
    }
}

// Classe Zoo con elenco di animali diversi
class Zoo {
    private ArrayList<Cane> cani = new ArrayList<>();
    private ArrayList<Gatto> gatti = new ArrayList<>();
    private ArrayList<Uccello> uccelli = new ArrayList<>();

    public void aggiungiCane(Cane cane) {
        cani.add(cane);
    }

    public void aggiungiGatto(Gatto gatto) {
        gatti.add(gatto);
    }

    public void aggiungiUccello(Uccello uccello) {
        uccelli.add(uccello);
    }

    public void stampaAnimali() {// stampa animali
        System.out.println("------ Elenco Cani ------");
        for (Cane cane : cani) {
            System.out.println(cane);
        }
        System.out.println("------ Elenco Gatti ------");
        for (Gatto gatto : gatti) {
            System.out.println(gatto);
        }
        System.out.println("------ Elenco Uccelli ------");
        for (Uccello uccello : uccelli) {
            System.out.println(uccello);
        }
    }
}

// Classe principale
public class EsercizioAnimaliEreditarietà {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Zoo z = new Zoo();
        ArrayList<Animale> animali = new ArrayList<>();
        String nomeCane, nomeGatto, nomeUccello;
        int etaCane, etaGatto, etaUccello;

        // Animali dati dal sistema
        animali.add(new Cane("Fido", 3));
        animali.add(new Gatto("Micia", 2));
        animali.add(new Uccello("Pippo", 1));

        // Stampa animali dati dal sistema
        System.out.println("------ Elenco animali ------");
        for (Animale a : animali) {
            System.out.println(a);
            a.faiVerso();
        }

        // Inserimento animali dall'utente
        System.out.println("Inserisci il nome del cane");
        nomeCane = sc.nextLine();
        System.out.println("Età: ");
        etaCane = sc.nextInt();
        sc.nextLine(); // pulizia buffer
        z.aggiungiCane(new Cane(nomeCane, etaCane));

        System.out.println("\nInserisci il nome e l'età di un gatto:");
        System.out.print("Nome: ");
        nomeGatto = sc.nextLine();
        System.out.print("Età: ");
        etaGatto = sc.nextInt();
        sc.nextLine();
        z.aggiungiGatto(new Gatto(nomeGatto, etaGatto));

        System.out.println("\nInserisci il nome e l'età di un uccello:");
        System.out.print("Nome: ");
        nomeUccello = sc.nextLine();
        System.out.print("Età: ");
        etaUccello = sc.nextInt();
        sc.nextLine();
        z.aggiungiUccello(new Uccello(nomeUccello, etaUccello));

        System.out.println("\n------ Animali nello Zoo ------");
        z.stampaAnimali();

        sc.close();
    }
}
