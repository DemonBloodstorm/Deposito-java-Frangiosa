public class CostruttoreConParametri {
    static class Auto {
        String marca;
        int anno;

        Auto(String marca, int anno) {
            this.marca = marca;
            this.anno = anno;
        }
    }

    public static void main(String[] args) {
        Auto miaAuto = new Auto("Tesla", 2023);
        System.out.println("Marca: " + miaAuto.marca);
        System.out.println("Anno: " + miaAuto.anno);
    }
}

