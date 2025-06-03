import java.util.Scanner;

/*
create un programma che richiede all’utente l’età, se ha la patente e se ha bevuto e in base alle
risposte ci dice se può guidare.
 */
public class Guidare_Esercizio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //apro lo scanner
        int eta;
        String patente, alcool;

        System.out.println("Dimmi quanti anni hai:"); // chiedo l'età
        eta = sc.nextInt(); // ottengo l'età
        sc.nextLine(); // consuma il newline rimasto dopo nextInt()

        if (eta < 14)  { //se ha meno di 14 anni non può in ogni caso guidare 
            System.out.println("Non puoi guidare");
        } else if (eta < 18) { // se ha meno di 18 anni potrebbe avere il patentino 
            System.out.println("Hai il patentino? [Si o No]"); // gli chiedo del patentino
            patente = sc.nextLine();

            if (patente.equalsIgnoreCase("Si")) { 
                System.out.println("Hai bevuto degli alcolici? [Si o No]");// gli chiedo visto che ha il patentino, se ha bevuto
                alcool = sc.nextLine();

                if (alcool.equalsIgnoreCase("No")) {
                    System.out.println("Puoi guidare un motorino"); 
                } else { // ha bevuto 
                    System.out.println("Non puoi guidare se hai bevuto");
                }
            } else {
                System.out.println("Non puoi guidare senza patentino"); 
            }
        } else { // eta maggiore di 18
            System.out.println("Hai la patente? [Si o No]"); // gli chiedo della patente
            patente = sc.nextLine();

            if (patente.equalsIgnoreCase("Si")) {
                System.out.println("Hai bevuto degli alcolici? [Si o No]"); // gli chiedo se ha bevuto visto che ha la patente
                alcool = sc.nextLine();

                if (alcool.equalsIgnoreCase("No")) { 
                    System.out.println("Puoi guidare");
                } else { // ha bevuto
                    System.out.println("Non puoi guidare se hai bevuto");
                }
            } else {// non ha la patente
                System.out.println("Non puoi guidare senza patente");
            }
        }
        sc.close(); //chiudo lo scanner
    }
}
