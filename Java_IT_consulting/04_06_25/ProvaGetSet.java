
import java.util.Scanner;

public class ProvaGetSet {
    
    public class Person { // Definizione della classe Person
        private String name;

        // Getter
        public String getName() { 
            return name;
        }

        // Setter
        public void setName(String newName) {
            this.name = newName;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Creato un oggetto Scanner per leggere l'input
        String name;
        
        ProvaGetSet outer = new ProvaGetSet(); // istanziamo la classe esterna
        Person p = outer.new Person(); // creiamo un oggetto Person
        System.out.println("Inserisci il nome:");
        p.setName(name = sc.nextLine());
        System.out.println(p.getName());
    }
}
