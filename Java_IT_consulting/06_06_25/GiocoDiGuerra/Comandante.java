
import java.util.ArrayList;
import java.util.List;

public class Comandante {
    private String nome;
    private int budget;
    private List<Combattente> esercito;
    private int guadagniTotali;
    
    // Costruttore che inizializza il nome e il budget del comandante
    public Comandante(String nome, int budget) {
        this.nome = nome;
        this.budget = budget;
        this.esercito = new ArrayList<>();
        this.guadagniTotali = 0;
    }
     // Getter 
    public String getNome() {
        return nome;
    }

    public int getBudget() {
        return budget;
    }

    public List<Combattente> getEsercito() {
        return esercito;
    }

    public int getGuadagniTotali() {
        return guadagniTotali;
    }
    
    // Creazione del soldato
    public void addSoldato(Combattente c) {
        if (c.getCosto() <= budget) {
            esercito.add(c);
            budget -= c.getCosto();
            System.out.println(nome + " ha arruolato: " + c.getDescrizione());
        } else {
            System.out.println("Budget insufficiente per " + c.getDescrizione());
        }
    }


    //guadagni 
    public void guadagna(int guadagno) {
        budget += guadagno;
        guadagniTotali += guadagno;
        System.out.println(nome + " ha guadagnato " + guadagno + " monete.");
    }
    //perdita soldi
    public void perdiSoldi(int perdita) {
        budget -= perdita;
        if (budget < 0) budget = 0;
        System.out.println(nome + " ha perso " + perdita + " monete.");
    }
    //Sconfitta o vittoria
    public boolean èSconfitto() {
        return esercito.stream().noneMatch(Combattente::èVivo); // Tutti i soldati sono morti o non ci sono soldati
    }
}
