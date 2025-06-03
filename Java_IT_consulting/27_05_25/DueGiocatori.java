import java.util.Scanner;
//Scrivete un gioco in cui il giocatore 1 inserisce un numero da 1 a 100 e il giocatore2 ha 5 tentativi per indovinare il numero. Il programma fornisce suggerimenti (troppo alto, troppo basso), termina quando l'utente indovina correttamente, quando i tentativi finiscono
public class DueGiocatori {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int NumeroGiocatore1, NumeroGiocatore2, tentativi = 5;
        
        while (true){
            System.out.println("Giocatore 1, inserisci un numero compreso tra 1 e 100: ");// Chiedo al giocatore 1 di inserire un numero compreso tra 1 e 100
            NumeroGiocatore1 = sc.nextInt();
            if (NumeroGiocatore1 < 1 || NumeroGiocatore1 > 100) {
                System.out.println("Il numero deve essere compreso tra 1 e 100.");//Informo di nuovo il giocatore 1 che il numero inserito deve essere compreso tra 1 e 100
            } else {
                break; // esce dal ciclo se il numero è valido
            }
        }
        
        
        System.out.println("Giocatore 2, hai " + tentativi + " tentativi per indovinare il numero.");
        while (tentativi > 0){
            System.out.println("Giocatore 2, inserisci il tuo tentativo: ");
            NumeroGiocatore2 = sc.nextInt();
            if(NumeroGiocatore2 < 1 || NumeroGiocatore2 > 100) {
                System.out.println("Il numero deve essere compreso tra 1 e 100.");//Informo il giocatore 2 che il numero deve essere compreso tra 1 e 100
                continue; // salta il resto del ciclo e chiede un nuovo tentativo
            }
            if (NumeroGiocatore2 == NumeroGiocatore1) {
                System.out.println("Congratulazioni! Hai indovinato il numero.");
                break; // esce dal ciclo se il numero è corretto
            } else if (NumeroGiocatore2 < NumeroGiocatore1) {
                System.out.println("Troppo basso! Riprova.");//Suggerimento per il giocatore 2
            } else {
                System.out.println("Troppo alto! Riprova.");//Suggerimento per il giocatore 2
            }
            tentativi--; // decrementa il numero di tentativi rimasti
            System.out.println("Tentativi rimasti: " + tentativi);
        }
        
        if (tentativi == 0) {
            System.out.println("Hai esaurito i tentativi! Il numero era: " + NumeroGiocatore1);// Informo il giocatore 2 che ha esaurito i tentativi e gli dico qual era il numero corretto
        }
        sc.close(); // chiudo lo scanner
       
    }
}