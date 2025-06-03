
import java.util.Scanner;

// scrivi un metodo che calcola la sommadi due numeri e restituisce il risultato
public class FunzioniEsercizio {
    public double somma(double a, double b){ // metodo che calcola la somma di due numeri e restituisce il risultato
        double somma;
        somma = a + b;
        return somma;
    }

    public int multiply(int c, int d){ // metodo che calcola il prodotto di due numeri e restituisce il risultato
        int prodotto;
        prodotto = c * d;
        return prodotto;
    }

    public double multiply(double c, double d){ // metodo che calcola il prodotto di due numeri e restituisce il risultato
        double risultato;
        risultato = c * d;
        return risultato;
    }

    public int sommaNaturali(int g){// Metodo che calcola la somma naturale di numeri
        if (g < 0) {
            return -1;
        }
        else if (g == 1) {
            return 1;
        }
        else {
            return g + sommaNaturali(g - 1);
        }
    }


    public static void main(String[] args) {
        FunzioniEsercizio funzioni = new FunzioniEsercizio();
        Scanner sc = new Scanner(System.in);
        System.out.println("Scegli quale tra questi vuoi eseguire");
        System.out.println("1) somma di numeri con la virgola");
        System.out.println("2) somma di numeri interi o con la virgola");
        System.out.println("3) somma naturale di numeri");
        int scelta = sc.nextInt();
        switch (scelta) {
            case 1:
                System.out.println("Inserisci il primo numero");
                double a = sc.nextDouble();
                System.out.println("Inserisci il secondo numero");
                double b = sc.nextDouble();
                System.out.println("Il risultato è " + funzioni.somma(a, b));
                break;
            case 2:
                System.out.println("Inserisci il primo numero");
                int c = sc.nextInt();
                System.out.println("Inserisci il secondo numero");
                int d = sc.nextInt();
                System.out.println("Il risultato è " + funzioni.multiply(c, d));
                break;
            case 3:
                System.out.println("Inserisci il numero");
                int e = sc.nextInt();
                System.out.println("Il risultato è " + funzioni.sommaNaturali(e));
                break;
            default:
                System.out.println("Scelta non valida");
                break;
        }
        sc.close();
    }
}
