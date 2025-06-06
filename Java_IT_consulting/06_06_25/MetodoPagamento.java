
abstract class MetodoPagamento {
    protected double importo;
    protected double budget;

    public MetodoPagamento(double importo, double budget) {
        this.budget = budget;
        this.importo = importo;
    }

    public void verificaImporto(){
         System.out.println("Importo da pagare: " + importo + " euro");
         System.out.println("Budget disponibile: " + budget + " euro");
         if (importo > budget) {
            System.out.println("Importo superiore al budget!");
        } else {
            System.out.println("Importo accettabile!");
        }
    }

     public abstract void paga();
}