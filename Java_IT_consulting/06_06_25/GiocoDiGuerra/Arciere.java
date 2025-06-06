public class Arciere extends Soldato {
    public Arciere(String nome) {
        super(nome, 90, 20); // poca salute, ma attacco discreto
    }

    @Override
    public int getCosto() {
        return 60;
    }

    @Override
    public int attacca() {
        // 30% di possibilità di colpire due volte
        if (Math.random() < 0.25) {
            return forzaAttacco * 2;
        }
        return forzaAttacco;
    }
}
