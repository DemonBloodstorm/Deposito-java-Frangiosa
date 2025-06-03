
//Scrivete un programma che chiede all'utente una parola e restituisce solo le vocali e l’indice della vocale all’interno della parola.
import java.util.Scanner;

public class LaParola {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // inizializza lo scanner per l'input dell'utente
        String parola; // Variabile per memorizzare la parola inserita dall'utente
        int[] posizione = new int[10]; // Array per memorizzare le posizioni delle vocali trovate, dimensione arbitraria
        char[] vocali = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}; // Array di vocali sia minuscole che maiuscole
        char lettera; // Variabile per memorizzare la lettera corrente
        char[] lettere = new char[10]; // Array per memorizzare le vocali trovate

        
        System.out.println("Scrivi una parola:");
        parola = sc.nextLine();
        for (int i = 0; i < parola.length(); i++) { // Itera su ogni lettera della parola
            lettera = parola.charAt(i); // Ottiene la lettera corrente dalla parola

            for (int j = 0; j < vocali.length; j++) { // Itera su ogni vocale per confrontare
                if (lettera == vocali[j]) {// Se la lettera corrente è una vocale
                    lettere[i] = lettera;
                    posizione[i] = i;
                    System.out.println("Vocale: " + lettera + ", Indice: " + (i+1));// Stampa la vocale e il suo indice es. vocale: a, indice: 1
                    break;// Esce dal ciclo interno se trova una vocale
                } 
            }
        }
        sc.close(); // Chiudo lo scanner
        return; // Termina il programma
    }
}   
