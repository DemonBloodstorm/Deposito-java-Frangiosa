import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioIncapsulamento3 {

    static class Aereo {
        private String modello;
        private int numeroPosti;
        private String codice;

        // Costruttore per inizializzare gli attributi privati
        public Aereo(String modello, int numeroPosti, String codice) {
            this.modello = modello;
            this.numeroPosti = numeroPosti;
            this.codice = codice;
        }

        // Getter e setter per gli attributi privati
        public String getModello() {
            return modello;
        }

        public void setModello(String modello) {
            this.modello = modello;
        }

        public int getNumeroPosti() {
            return numeroPosti;
        }

        public void setNumeroPosti(int numeroPosti) {
            if (numeroPosti < 0) {
                System.out.println("Numero posti non valido");
            } else {
                this.numeroPosti = numeroPosti;
            }
        }

        public String getCodice() {
            return codice;
        }

        public void setCodice(String codice) {
            this.codice = codice;
        }

        // Metodo toString per stampare gli attributi privati
        @java.lang.Override
        public String toString() {
            return "Modelllo = "+modello + ", Numero di posti = " + numeroPosti + ", Codice identificativo = " + codice;
        }
    }

    static class Pilota {
        private String nome;
        private String numeroBrevetto;
        private int oreVolo;

        // Costruttore per inizializzare gli attributi privati
        public Pilota(String nome, String numeroBrevetto, int oreVolo) {
            this.nome = nome;
            this.numeroBrevetto = numeroBrevetto;
            this.oreVolo = oreVolo;
        }

        // Getter e setter per gli attributi privati
        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getNumeroBrevetto() {
            return numeroBrevetto;
        }

        public void setNumeroBrevetto(String numeroBrevetto) {
            this.numeroBrevetto = numeroBrevetto;
        }

        public int getOreVolo() {
            return oreVolo;
        }

        public void setOreVolo(int oreVolo) {
            if (oreVolo < 0) {
                System.out.println("Ore volo non valido");
            } else {
                this.oreVolo = oreVolo;
            }
        }

        // Metodo toString per stampare gli attributi privati
        @java.lang.Override
        public String toString() {
            return "nome = "+nome + ", Numero di Brevetto = " + numeroBrevetto + ", Ore di volo totali = " + oreVolo;
        }
    }

    static class CompagniaAerea {
        private String nome;
        private ArrayList<Aereo> flotta = new ArrayList<>();
        private ArrayList<Pilota> piloti = new ArrayList<>();

        // Getter e setter
        public CompagniaAerea(String nome) {
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public ArrayList<Aereo> getFlotta() {
            return flotta;
        }

        public void setFlotta(ArrayList<Aereo> flotta) {
            this.flotta = flotta;
        }

        public ArrayList<Pilota> getPiloti() {
            return piloti;
        }

        public void setPiloti(ArrayList<Pilota> piloti) {
            this.piloti = piloti;
        }

        public void aggiungiAereo(Aereo aereo) {
            flotta.add(aereo);
        }

        public void aggiungiPilota(Pilota pilota) {
            piloti.add(pilota);
        }

        // Metodo toString per stampare la compagnia e la flotta di aerei e piloti
        public String toString() {
            String result = "Compagnia: " + nome + "\nFlotta:\n";

            for (Aereo a : flotta) {
                result += "  " + a + "\n"; // aggiungi ogni aereo con indentazione
            }

            result += "Piloti:\n";

            for (Pilota p : piloti) {
                result += "  " + p + "\n"; // aggiungi ogni pilota con indentazione
            }

            return result;
        }

        public String ricercaPilota(String nome) {
            for (Pilota p : piloti) {
                if (p.getNome().equalsIgnoreCase(nome)) {
                    return p.toString();
                }
            }
            return "Pilota non trovato";
        }

        public String ricercaAereo(String codice) { // Ricerca dell'aereo
            for (Aereo a : flotta) {
                if (a.getCodice().equalsIgnoreCase(codice)) {
                    return a.toString();
                }
            }
            return "Aereo non trovato";
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nome, codice;
        int scelta;

        Aereo a1 = new Aereo("Boeing 737", 180, "B737-001");
        Aereo a2 = new Aereo("Boeing 737", 180, "B736-001");
        Pilota p1 = new Pilota("Luca", "BR123", 1200);
        Pilota p2 = new Pilota("Lucia", "BR122", 1100);

        CompagniaAerea compagnia = new CompagniaAerea("NelBlu");
        compagnia.aggiungiAereo(a1);
        compagnia.aggiungiAereo(a2);
        compagnia.aggiungiPilota(p1);
        compagnia.aggiungiPilota(p2);

        System.out.println(compagnia);
        System.out.println("1. Ricerca pilota\n");
        System.out.println("2. Ricerca aereo\n");
        scelta = sc.nextInt();
        sc.nextLine();
        // ricerca pilota e aereo
        switch(scelta){
            case 1:
                System.out.println("Inserisci il nome del pilota che stai cercando: ");
                nome = sc.nextLine();
                System.out.println(compagnia.ricercaPilota(nome));
                break;
            case 2:
                System.out.println("inserisci il codice aereo che stai cercando: ");
                codice = sc.nextLine();
                System.out.println(compagnia.ricercaAereo(codice));
                break;
            default:
                System.out.println("Scelta non valida");
                break;
        }
        sc.close();
    }
}
