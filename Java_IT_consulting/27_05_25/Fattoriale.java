/*Creare un metodo che accetti un numero
intero e restituisca il suo
fattoriale.
Se il parametro passato è una stringa
scrive “Inserisci un numero valido”
(svolgere l’esercizio con
l’overloading)*/
import java.util.Scanner;

public class Fattoriale {

    public static int calcoloFattoriale(int numero) { // Metodo per calcolare il fattoriale di un numero intero
        if (numero < 0 || numero > 19) { // Controlla se il numero è negativo o troppo grande
            System.out.println("Inserisci un numero valido");
            return -1; // Indica un errore
        }

        int risultato = 1; // Inizializza il risultato a 1, poiché il fattoriale di 0 è 1
        for (int i = 2; i <= numero; i++) {
            risultato *= i;
        }

        return risultato;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci un numero intero: ");
        int numero = scanner.nextInt(); // Legge un numero intero dall'utente

        int risultato = calcoloFattoriale(numero); // Chiamata al metodo per calcolare il fattoriale
        if (risultato != -1) { // Controlla se il risultato è valido
            System.out.println("Il fattoriale è: " + risultato);
        }

        scanner.close(); // Chiudo lo scanner
    }
}

