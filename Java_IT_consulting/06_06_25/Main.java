
public class Main {
    public static void main(String[] args) {
        // Primo pagamento con CartaDiCredito da 100 euro
        MetodoPagamento carta = new CartaDiCredito(100, 150);
        carta.verificaImporto();
        carta.paga();

        System.out.println();

        // Secondo pagamento con PayPal da 50 euro
        MetodoPagamento paypal = new PayPal(50, 100);
        paypal.verificaImporto();
        paypal.paga();
    }
}
