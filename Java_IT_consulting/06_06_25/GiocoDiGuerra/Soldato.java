
public abstract class Soldato implements Combattente{

    protected String nome;
    protected int salute;
    protected int forzaAttacco;

    public Soldato(String nome, int salute, int forzaAttacco){
        this.nome = nome;
        this.salute = salute;
        this.forzaAttacco = forzaAttacco;
    }

    @Override
    public int attacca() {
        return forzaAttacco;
    }

     @Override
    public void riceviDanno(int danno) {
       salute -= danno;
        
    }

        @Override
    public boolean èVivo() {
        return salute > 0;
    }


    @Override
    public String getDescrizione() {
        return nome +" (HP: " +salute + " Attacco: " + forzaAttacco +")";
    }

}
