/*Create uno script che richiede all’utente Nome, anno di
nascita e giorno della settimana (a numero) e stampa in
maniere formattata oltre al nome, l’età e i giorni che mancano
al prossimo weekend (sabato):
Esempio
’Il tuo nome è Tommaso, hai 38 anni e mancano 3 giorni al
weekend’ */
import java.util.Scanner;

public class Quanto_Al_sabato {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String name, surname; 
    int Anno_nascita, Anni, giorno_della_settimana, Anno_ora, Sabato = 6; // Inizializzo a 6 Sabato per far si che sia al numero di sabato
    System.out.println("Inserisci il tuo nome:"); // chiedo il nome all'utente
    name= sc.nextLine(); // ottengo il nome
    System.out.println("Inserisci il tuo cognome:");  // chiedo il cognome all'utente
    surname = sc.nextLine(); // ottengo il cognome
    System.out.println("Inserisci il tuo anno di nascita (YYYY):");  // chiedo l'anno di nascita all'utente
    Anno_nascita = sc.nextInt(); // ottengo l'anno di nascita
    System.out.println("Inserisci l'anno corrente (YYYY):");  // chiedo che anno in formato (YYYY) è all'utente, dovrei mettere un controllo per far si che non si possa mettere una anno più piccolo di quello di nascita, sia troppo grande o lo stesso di quello di nascita
    Anno_ora= sc.nextInt(); // ottengo l'anno odierno
    Anni = Anno_ora - Anno_nascita; // Uso l'intero Anni per immagazinare la differenza tra l'anno attuale e quello di nascita per ottenere l'età del soggetto
    System.out.println("Inserisci che giorno della settimana è oggi(1-lunedi,2-martedi...7-domenica):"); // chiedo che giorno è (1- lunedi, 2-martedi, 3- mercoledi, 4- giovedi, 5- venerdi, 6- sabato, 7-domenica)
    giorno_della_settimana= sc.nextInt();// ottengo il giorno della settimana, ci vorrebbe un if per far si che non venga messo un numero più piccolo di 1 o più grande di 7
    Sabato = Sabato - giorno_della_settimana; // faccio la differenza tra il numero che è il sabato e che giorno è ora, così che so quanti giorni mancano a sabato
    if (Sabato == -1) // con il metodo utilizzato mi uscirebbe -1 se è domenica e quindi devo usare l'if per evitare che esca scritto -1 giorni a sabato
        Sabato = 6;
    System.out.println("Il tuo nome è "+ name +" "+ surname +" hai "+ Anni + " anni e mancano "+ Sabato + " giorni a sabato"  );
    sc.close();
    }
}
