public class EsempioOverloading {
   public static class Calculator{
    //metodo per sommare due numeri interi
    public int add(int a, int b){
        return a + b;  
    }
    //metodo per sommare tre numeri interi
    public int add(int a, int b, int c){
        return a + b + c;
    }
    //metodo per sommare due numeri decimali
    public double add(double a, double b){
        return a + b;
    }
   }
    public static void main(String[] args) {
    Calculator calc = new Calculator();

    //usp dell'overloading
    System.out.println("Somma di due interi: "+ calc.add(5, 6));
    System.out.println("Somma di tre interi: "+ calc.add(5, 6, 7));
    System.out.println("Somma di due double: "+ calc.add(5.5, 6.5));
    }
    
}