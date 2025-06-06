import java.util.Scanner;

class Persona {
    public void Saluta() {
        System.out.println("Ciao");
    }
}

class Pirata extends Persona {
    @Override
    public void Saluta() {
        System.out.println("Arrrrgh. Sono un pirata");
    }
}

public class SalutoEsercizio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Persona p = new Persona();
        Pirata pi = new Pirata();
        
        p.Saluta();
        pi.Saluta();
    }
}
