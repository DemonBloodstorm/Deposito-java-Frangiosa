public class Cavaliere extends Soldato {
    public Cavaliere(String nome) {
        super(nome, 180, 40); // più salute, buona forza
    }

    @Override
    public int getCosto() {
        return 100;
    }

    @Override
    public int attacca() {
        // 35% di possibilità di infliggere danno doppio (colpo critico)
        if (Math.random() < 0.35) {
            return forzaAttacco * 3;
        }
        return forzaAttacco;
    }
}
