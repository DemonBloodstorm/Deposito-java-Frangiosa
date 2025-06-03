//Scrivi un sistema Java che:Crei una ArrayList di stringhe per memorizzare nomi di studenti. L'utente può aggiungere nomi finché non scrive "fine". Il programma deve stampare tutti i nomi in ordine alfabetico. Il programma deve dire quanti studenti sono stati inseriti. Il programma deve permettere di eliminare degli studenti indicati dall’utente

import java.util.ArrayList;
import java.util.Scanner;

public class Studenti {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> studenti = new ArrayList<>();
        String nome, risposta, studenteDaEliminare;
        while (true){
            System.out.println("Inserisci il nome dello studente (o scrivi 'fine' per terminare):");
            nome = sc.nextLine(); // Legge il nome dello studente e lo converte in minuscolo per evitare problemi di confronto

            if (nome.equalsIgnoreCase("fine")) {
                break; // Esce dal ciclo se l'utente scrive "fine"
            
            }
            studenti.add(nome); // Aggiunge il nome alla lista
        }
        studenti.sort(String::compareToIgnoreCase); // Ordina i nomi in ordine alfabetico
        System.out.println("Nomi degli studenti in ordine alfabetico: ");

        for (String studente : studenti) {
            System.out.println(studente); // A ogni iterazione stampa il nome di uno studente precedentemente inserito
        }

        System.out.println("Numero totale di studenti inseriti: " + studenti.size()); // Stampa il numero di studenti
        System.out.println("Vuoi eliminare uno studente? (si/no)");
        risposta = sc.nextLine();

        while (risposta.equalsIgnoreCase("si")) { // se si vuole eliminare uno studente
            System.out.println("Inserisci il nome dello studente da eliminare:"); 
            studenteDaEliminare = sc.nextLine().toLowerCase(); // Legge il nome dello studente da eliminare e lo converte in minuscolo per evitare problemi di confronto
            
            if (studenti.remove(studenteDaEliminare)) { // Rimuove lo studente dalla lista e verifica se è stato rimosso con successo
                System.out.println("Studente " + studenteDaEliminare + " eliminato.");
            } else { // Se lo studente non è stato trovato nella lista
                System.out.println("Studente " + studenteDaEliminare + " non trovato.");
            }
            System.out.println("Vuoi eliminare un altro studente? (si/no)"); // Chiede se si vuole eliminare un altro studente
            risposta = sc.nextLine(); // Legge la risposta dell'utente
        }

        sc.close();
        return;
    }
}
