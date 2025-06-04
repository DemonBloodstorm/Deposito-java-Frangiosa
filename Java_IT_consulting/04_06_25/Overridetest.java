
public class Overridetest {

    class Veicolo {
        void run() {
            System.out.println("Il veicolo è in movimento");
        }
    }

    class Bike extends Veicolo {
        @java.lang.Override
        void run() {
            System.out.println("La bicicletta è in movimento");
        }
    }

    public static void main(String[] args) {
        Overridetest o = new Overridetest();
        Veicolo b = o.new Bike(); // Polimorfismo
        b.run(); // Chiama il metodo della sottoclasse (override)
    }
}

