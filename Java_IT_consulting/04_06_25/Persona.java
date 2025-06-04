public class Persona {
    // campi privati (incapsulamento)
    private String nome;
    private int eta; // 

    // costruttore pubblico
    public Persona(String nome, int eta){
        this.nome = nome;
        this.eta = eta;
    }

    // metodo privato
    private boolean verificaMaggiorenne(){
        return this.eta >= 18; //  maggiorenne se >=18
    }

    // metodo pubblico
    public void stampaStatus(){
        if(verificaMaggiorenne()){
            System.out.println(this.nome + " è un maggiorenne");
        } else {  
            System.out.println(this.nome + " è un minorenne");
        }
    }

    // main
    public static void main(String[] args) {
        Persona p1 = new Persona("Mario", 25);
        Persona p2 = new Persona("Luigi", 15);

        p1.stampaStatus(); // Mario è un maggiorenne
        p2.stampaStatus(); // Luigi è un minorenne
    }
}
