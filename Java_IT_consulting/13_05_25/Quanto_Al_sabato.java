/*Create uno script che richiede all’utente Nome, anno di
nascita e giorno della settimana (a numero) e stampa in
maniere formattata oltre al nome, l’età e i giorni che mancano
al prossimo weekend (sabato):
Esempio
’Il tuo nome è Tommaso, hai 38 anni e mancano 3 giorni al
weekend’ */
import java.util.Scanner;

class Quanto_Al_sabato {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String nome, cognome;
        int annoNascita, annoCorrente, eta;
        int giornoSettimana; // 1 = lunedì ... 7 = domenica
        final int SABATO = 6;

        // Input nome
        System.out.print("Inserisci il tuo nome: ");
        nome = sc.nextLine();

        // Input cognome
        System.out.print("Inserisci il tuo cognome: ");
        cognome = sc.nextLine();

        // Input anno di nascita con controllo
        do {
            System.out.print("Inserisci il tuo anno di nascita (es. 1990): ");
            annoNascita = sc.nextInt();
        } while (annoNascita < 1900 || annoNascita > 2100);

        // Input anno corrente con controllo
        do {
            System.out.print("Inserisci l'anno corrente: ");
            annoCorrente = sc.nextInt();
        } while (annoCorrente < annoNascita || annoCorrente > 2100);

        eta = annoCorrente - annoNascita;

        // Input giorno della settimana con controllo
        do {
            System.out.print("Che giorno della settimana è oggi (1 = lunedì, ..., 7 = domenica)? ");
            giornoSettimana = sc.nextInt();
        } while (giornoSettimana < 1 || giornoSettimana > 7);

        // Calcolo giorni mancanti al sabato
        int giorniAlSabato = SABATO - giornoSettimana;
        if (giorniAlSabato < 0) {
            giorniAlSabato += 7; // esempio: se oggi è domenica (7), mancano 6 giorni
        }

        // Output finale
        System.out.println("Il tuo nome è " + nome + " " + cognome + ", hai " + eta + 
                           " anni e mancano " + giorniAlSabato + " giorni al weekend (sabato).");

        sc.close();
    }
}

