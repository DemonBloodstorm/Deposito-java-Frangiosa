

public class CartaDiCredito extends MetodoPagamento {
    public CartaDiCredito(double importo, double budget) {
        super(importo, budget);
    }

    @Override
    public void verificaImporto() {
        super.verificaImporto();
        System.out.println("Controllo disponibilità sulla carta...");
    }

    @Override
    public void paga() {
       if (importo > budget) {
            System.out.println("Pagamento con carta di credito rifiutato: fondi insufficienti.");
            return;
        }
        else{

        budget -= importo;
        System.out.println("Pagamento con carta di credito effettuato.");
        System.out.println("Nuovo budget: " + budget + " euro");
        }
    }
}

class PayPal extends MetodoPagamento {

    public PayPal(double importo, double budget) {
        super(importo, budget);
    }

    @Override
    public void verificaImporto() {
        super.verificaImporto();
        System.out.println("Verifica account PayPal...");
    }

    @Override
    public void paga() {
        if (importo > budget) {
            System.out.println("Pagamento con PayPal rifiutato: fondi insufficienti.");
            return;
        }
        else{
        budget -= importo;
        System.out.println("Accesso a PayPal... Pagamento completato.");
        }
    }
}
