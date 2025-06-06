public class Lanciere extends Soldato {
    public Lanciere(String nome) {
        super(nome, 100, 25); // equilibrio tra salute e attacco
    }

    @Override
    public int getCosto() {
        return 75;
    }

    @Override
    public int attacca() {
        // Bonus del 25% al danno (anti-cavalieri o simile)
        return (int)(forzaAttacco * 1.25);
    }
}
