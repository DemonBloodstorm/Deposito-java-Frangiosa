/*Scrivete un programma che chiede una stringa all’utente e
restituisce un HashMap rappresentante la "frequenza di
comparsa" di ciascun carattere componente la stringa.
Esempio:
Stringa "ababcc",
Risultato
{"a": 2, "b": 2, "c": 2} */

import java.util.HashMap;
import java.util.Scanner;

public class FrequenzaDiComparsa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Scrivi una stringa: ");
        String parola = sc.nextLine().toLowerCase(); // Converte tutto in minuscolo

        if (parola.isEmpty()) { // Controlla se la stringa è vuota
            System.out.println("La stringa è vuota.");
            sc.close();
            return;
        }

        HashMap<Character, Integer> frequenza = new HashMap<>(); // Mappa per memorizzare la frequenza dei caratteri

        for (char c : parola.toCharArray()) { // Itera ogni carattere
            if (frequenza.containsKey(c)) { // Controlla se il carattere è già presente
                frequenza.put(c, frequenza.get(c) + 1); // Incrementa la frequenza
            } else {
                frequenza.put(c, 1); // Aggiunge il carattere con frequenza 1
            }
        }

        System.out.println("Frequenza dei caratteri:"); 
        for (char c : frequenza.keySet()) {
            System.out.println(c + " = " + frequenza.get(c));
        }
        sc.close();
        
        
    }
}