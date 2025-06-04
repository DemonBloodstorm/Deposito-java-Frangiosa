
import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioIncapsulamento2 {
    public static class Studente {
        private String nome;
        private String cognome;
        private static int id;
        public int voto;

        // Costruttore che prende nome e cognome e incrementa id
        public Studente(String nome, String cognome, int voto) {
            this.nome = nome;
            this.cognome = cognome;
            setVoto(voto);
            id++;
        }

        // Metodo per stampare nome e cognome e id
        public String getNome() {
            return nome;
        }

        public String getCognome() {
            return cognome;
        }

        public int getId() {
            return id;
        }

        public int getVoto() {
            return voto;
        }

        public void setVoto(int voto) {
            if (voto > 0 && voto < 10) {
                    this.voto = voto;
            } 
            else {
                this.voto = -1; // valore speciale per "non valido"
                System.out.println("Voto non valido, lo studente non sarà inserito.");
            }
        }

        // Metodo toString per stampare nome, cognome e id messi in ordine
        @java.lang.Override
        public String toString() {
            return "Studente id=" + id + " cognome = " + cognome + " " + ", nome = " + nome + " voto = " + voto + "\n";
        }
        
    }
        public static void cercaStudentePerNome(ArrayList<Studente> studenti, String nome) {
            boolean trovato = false;
            for (Studente s : studenti) {
                if (s.getNome().equalsIgnoreCase(nome)) {
                    System.out.println(s);
                    trovato = true;
                }   
            }
            if (!trovato) {
                System.out.println("Nessuno studente trovato con il nome: " + nome);
            }
        }
    

    public static void main(String[] args) {
        ArrayList<Studente> studenti = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        String nomeCercato; 

        Studente studente1 = new Studente("Mario", "Rossi", 27);
        if(studente1.getVoto() != -1)
        studenti.add(studente1);
        Studente studente2 = new Studente("Mario", "Bianchi", 7);
        if(studente2.getVoto()!= -1)
        studenti.add(studente2);

        // Stampa tutti gli studenti
        for (Studente s : studenti) {
            System.out.println(s);
        }

        // Cerca studente per nome
        System.out.println("Inserisci il nome da cercare: ");
        nomeCercato = sc.nextLine();
        cercaStudentePerNome(studenti, nomeCercato);
        sc.close();
    }
}
