/*
create un programma che richiede all’utente tre numeri e ci
restituisce se ci sono 2
numeri uguali altrimenti il numero più grande dei tre
 */

import java.util.Scanner;

public class TreNumeri {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int numero1, numero2, numero3, max;
        //chiedo all'utente i tre numeri interi
        System.out.println("Dammi un numero intero:");
        numero1 = sc.nextInt();
        System.out.println("Dammi un altro numero intero:");
        numero2 = sc.nextInt();
        System.out.println("Dammi un ultimo numero intero:");
        numero3 = sc.nextInt();
        //controllo se ci sono numeri uguali
        if (numero1 == numero2){ 
            System.out.println("Questi due numeri sono uguali: "+ numero1+ " ,"+ numero2);
        }
        else if (numero3 == numero2){
             System.out.println("Questi due numeri sono uguali: "+ numero3+ " ,"+ numero2);
        }
        else if ( numero3 == numero1){
            System.out.println("Questi due numeri sono uguali: "+ numero3+ " ,"+ numero1);
        }
        // ora che so che non ci sono numeri uguali controllo quale dei tre è il maggiore
        else{
            max = numero1; // riempo max con numero1
            if(numero2 > max){
                max = numero2; // numero2 è maggiore
            }
            if(numero3 > max){
                max = numero3; // numero3 è maggiore
            }
            System.out.println(max + " è il numero maggiore dei tre" ); // Dico quale numero è il maggiore
        }
        sc.close(); // chiudo lo scanner
    }
 }