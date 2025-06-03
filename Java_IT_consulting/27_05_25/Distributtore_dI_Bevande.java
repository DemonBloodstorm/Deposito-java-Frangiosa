/*Scrivi un programma Java che simuli il funzionamento di un distributore automatico di bevande. L'utente inizia con un certo credito iniziale (ad esempio, 10€).
 Il programma mostra un menu con le seguenti opzioni:
 1. Caffè - 1.50€
 2. Cappuccino - 2.00€
 3. Tè - 1.00€
 4. Acqua - 0.50€
 5. Uscire
L'utente può selezionare una bevanda e il costo viene scalato dal credito disponibile.Se il credito non è sufficiente, il programma deve avvisare l'utente e chiedere una nuova scelta.
L'utente può continuare a comprare bevande finché non sceglie di uscire o esaurisce il credito.
Alla fine, il programma stampa il credito rimanente e un messaggio di chiusura.*/
import java.util.Scanner;
public class Distributtore_dI_Bevande {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double credito = 10.0; // Credito iniziale
        int scelta;

        System.out.println("Benvenuto!");
        while (true) { 
            
            System.out.println("Credito disponibile: " + credito + " euro");
            System.out.println("Scegli la bevanda che vuoi bere:");
            System.out.println("1. Caffè - 1.50€");
            System.out.println("2. Cappuccino - 2.00€");
            System.out.println("3. Tè - 1.00€");
            System.out.println("4. Acqua - 0.50€");
            System.out.println("5. Uscire");
            scelta = sc.nextInt();
            switch (scelta){
                case 1: // scelta del caffè
                    if (credito >= 1.50) {
                        credito -= 1.50;
                        System.out.println("Hai acquistato un Caffè.");
                    } else {
                        System.out.println("Credito insufficiente per un Caffè.");
                        return; // Esce dal ciclo se il credito è insufficiente
                    }
                    break;
                case 2: // scelta del cappuccino
                    if (credito >= 2.00) {
                        credito -= 2.00;
                        System.out.println("Hai acquistato un Cappuccino.");
                    } else {
                        System.out.println("Credito insufficiente per un Cappuccino.");
                        return; // Esce dal ciclo se il credito è insufficiente
                    }
                    break;
                case 3: // scelta del tè
                    if (credito >= 1.00) {
                        credito -= 1.00;
                        System.out.println("Hai acquistato un Tè.");
                    } else {
                        System.out.println("Credito insufficiente per un Tè.");
                        return; // Esce dal ciclo se il credito è insufficiente
                    }
                    break;
                case 4: // scelta dell'acqua
                    if (credito >= 0.50) {
                        credito -= 0.50;
                        System.out.println("Hai acquistato un'Acqua.");
                    } else {
                        System.out.println("Credito insufficiente per un'Acqua.");
                        return; // Esce dal ciclo se il credito è insufficiente
                    }
                    break;
                case 5: // Uscire dalla macchinetta
                    System.out.println("Grazie per aver utilizzato il distributore automatico. Arrivederci!");
                    System.out.println("Credito rimanente: " + credito + "€");
                    sc.close(); // Chiudo lo scanner
                    return; // Esce dal programma
                default: // Nel caso di un numero non valido
                System.out.println("Scelta non valida. Per favore, scegli un'opzione valida.");
                    break;
                }
                if (credito <= 0.50) { // Controllo se c'è credito sufficiente per continuare il ciclo
                System.out.println("Credito esaurito. Arrivederci!");
                System.out.println("Credito rimanente: " + credito + " euro");// Stampo il credito rimanente
                sc.close(); // Chiudo lo scanner
                return; // Esce dal programma
                }
                else {
                System.out.println("Credito rimanente: " + credito + " euro");
                sc.close(); // Chiudo lo scanner
                return; // Esce dal programma
                }
        }
    }
}
