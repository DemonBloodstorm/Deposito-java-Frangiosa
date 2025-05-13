public class PrimeVariabili{
    public static void main(String[] args) {
        int provaNumero = 12; //test Int
        String provaTesto = "Ciao Mondo"; // test String
        boolean provaBool = true; // test boolean
        //final int provaNumero = 15; // variable provaNumero is already defined in method main(String[])
        //provaNumero = 20; // error: cannot assign a value to final variable provaNumero
        // test stampa delle varaiabili e stampa congiunta
        String testo = "Mondo";
        System.out.println("Ciao"+ testo);
        String firstPart = "Ciao";
        String lastpart = "Mondo";
        String fullPart = firstPart + lastpart;
        System.out.println(fullPart);
        //Per i valori numerici il + funziona come un operatore matematico
        int a = 5;
        int b = 6;
        System.out.println(a + b);
        //Dichiarazione monotipizzata di più variabili (refer)
        int x = 5, y = 6, z = 50;
        System.out.println(x + y + z);
        // È anche possibile assegnare lo stesso valore a più variabili monotipo su una sola riga 
        // dichiarazione a cascata
        int c, v, n;
        c = v = n = 50;
        System.out.println(c + v + z);
        //Buono
        int minutiPerOra = 60;
        // Non è facile da intuire
        int m = 60;
        // Test double
        double myDouble = 12E4d;
        System.out.println(myDouble);
        //test float 
        float myFloat = 35e3f;
        System.out.println(myFloat);
    }
}