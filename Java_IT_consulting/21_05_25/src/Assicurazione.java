
/*Esercizio
Scrivi un programma Java che calcoli il preventivo per un'assicurazione auto in base ai
seguenti criteri:
1.Età del conducente:
⚬ Meno di 18 anni → "Non sei idoneo per l'assicurazione"
⚬ 18 - 25 anni → Applica una maggiorazione del 20% sul prezzo base
⚬ 26 - 50 anni → Nessuna maggiorazione
⚬ Più di 50 anni → Sconto del 10%
2.Anni di esperienza alla guida:
⚬ Meno di 2 anni → Applica una maggiorazione del 30% sul prezzo base
⚬ 2 o più anni → Nessuna maggiorazione
3.Numero di incidenti negli ultimi 5 anni:
⚬ 0 incidenti → Nessun aumento
⚬ 1 incidente → Aumento del 15%
⚬ 2 o più incidenti → Aumento del 30%
⚬ Più di 4 incidenti → "Non sei idoneo per l'assicurazione"
4.Scelta del pacchetto assicurativo:
⚬ Base: Prezzo standard
⚬ Intermedio: +20%
⚬ Premium: +50%
Prezzo base dell'assicurazione: 500€ */
import java.util.Scanner;

public class Assicurazione {
    public static void main(String[] args) {
     Scanner sc = new Scanner (System.in);

    int eta, exp, incidenti, scelta;
    double prezzo = 500;

    //Chiedo l'età dell'utente perché se è minorenne non ha senso continuare la proceduura
    System.out.println("Quanti anni hai?");
    eta = sc.nextInt();
    if(eta < 18){
         System.out.println("Non sei idoneo per l'assicurazione");
         return;
    }
    else if (eta < 25 ){
        System.out.println("Avendo meno di 25 anni c'è unaumento del 20%");
        prezzo = prezzo*1.20; // +20%
    }
    else if (eta > 50 ){
        System.out.println("Avendo più di 50 anni c'è uno sconto del 10%");
        prezzo = prezzo*0.90; // -10%
    }
    // tra i 26 e i 50 non ha ne aumenti di prezzo ne sconti

    System.out.println("Quanti anni di esperienza hai alla guida?");
    exp = sc.nextInt();
    if(exp < 2){
        System.out.println("Visto che hai meno di due anni di esperienza c'è una maggiorazione del 30%");
        prezzo = prezzo*1.30; // +30%
    }
    System.out.println("Quanti incidenti hai fatto negli ultimi 5 anni?");
    incidenti = sc.nextInt();
    if (incidenti > 4){
        System.out.println("Non sei idoneo all'assicurazione");
        return;
    }
    else if (incidenti == 1){
        System.out.println("Visto che hai fatto 1 incidente c'è una maggiorazione del 15%");
        prezzo = prezzo*1.15;
    }
    else if (incidenti > 2){
        prezzo = prezzo*1.30;
    }
    System.out.println("Che tipo di pacchetto vuoi? [\r\n 1 Base: Prezzo standard\r\n" + "2 Intermedio: +20%\r\n" + "3 Premium: +50%\r\n" + "Prezzo base dell'assicurazione: 500€]");
    scelta = sc.nextInt();
    switch(scelta){
        case 1:
                // prezzo invariato
                break;
            case 2:
                prezzo *= 1.20; // +20%
                break;
            case 3:
                prezzo *= 1.50;// +50%
                break;
            default:
                System.out.println("Scelta non valida, considerato pacchetto Base");
                break;
    }
    System.out.println("Il prezzo finale dell'assicurazione è: \n"+ prezzo);
    sc.close();
    }
}