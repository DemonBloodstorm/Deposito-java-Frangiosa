import java.util.ArrayList;

// Classe base Camera
class Camera {
    private int numero;
    private float prezzo;

    public Camera(int numero, float prezzo) {// costruttore di Camera con parametri numero e prezzo
        this.numero = numero;
        this.prezzo = prezzo;
    }

    // Getter e Setter
    public int getNumero() {
        return numero;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    // Metodo dettagli di Camera
    public String dettagli() {
        return "Camera numero: " + numero + ", prezzo: " + prezzo;
    }

    // Metodo dettagli con parametro booleano conPrezzo (overloading)
    public String dettagli(boolean conPrezzo) {
        if (conPrezzo) {
            return "Camera numero: " + numero + ", prezzo: " + prezzo;
        } else {
            return "Camera numero: " + numero;
        }
    }
}

// Sottoclasse Suite
class Suite extends Camera {
    private String serviziExtra;

    public Suite(int numero, float prezzo, String serviziExtra) {
        super(numero, prezzo);
        this.serviziExtra = serviziExtra;
    }

    public void setServiziExtra(String serviziExtra) {
        this.serviziExtra = serviziExtra;
    }

    public String getServiziExtra() {
        return serviziExtra;
    }

    // Override del metodo dettagli di Camera per aggiungere servizi extra
    @Override
    public String dettagli() {
        return super.dettagli() + ", servizi extra: " + serviziExtra;
    }
}

// Classe Hotel
class Hotel {
    private String nome;
    private ArrayList<Camera> camere;

    public Hotel(String nome) { // costruttore di Hotel con parametro nome e inizializzazione ArrayList camere
        this.nome = nome;
        camere = new ArrayList<>();
    }

    public void aggiungiCamera(Camera camera) { // metodo per aggiungere una camera all'ArrayList camere
        camere.add(camera);
    }

    public void dettagli() { // metodo per stampare i dettagli di tutte le camere nell'ArrayList camere
        for (Camera camera : camere) {
            System.out.println(camera.dettagli());
        }
    }

    public int contaSuite() { // metodo per contare il numero di suite nell'ArrayList camere
        int count = 0;
        for (Camera camera : camere) {
            if (camera instanceof Suite) {
                count++;
            }
        }
        return count;
    }
}

public class EsercizioHotel {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Grand Hotel");

        // Aggiunta delle camere all'hotel
        hotel.aggiungiCamera(new Camera(1, 100));
        hotel.aggiungiCamera(new Suite(2, 200, "Piscina"));
        hotel.aggiungiCamera(new Camera(3, 300));
        hotel.aggiungiCamera(new Suite(4, 400, "Spa"));

        // Stampa dei dettagli delle camere
        System.out.println("Dettagli delle camere:");
        hotel.dettagli();

        // Conteggio delle suite
        System.out.println("\nNumero di suite: " + hotel.contaSuite());
    }
}
