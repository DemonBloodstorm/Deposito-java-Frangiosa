
public class ProvaClassi {
    static class Auto{
        String marca;
        int anno;
        double prezzo;
        void mostraInfo(){
            System.out.println(marca+" - "+anno+" -€ "+prezzo);
        }
    }
    
    public static void main(String[] args) {
        Auto miaAuto = new Auto(); // Creazione oggetto

        miaAuto.marca = "Tesla"; // Assegnazione valori
        miaAuto.anno = 2023;
        miaAuto.prezzo = 59999.99;

        miaAuto.mostraInfo(); // Richiamo metodo
    }
    
}
