package objetos;


public class Quarto {

    public int numero;
    public String tipo;
    public double preco;
    public String disponivel;


    public Quarto(int numero, String tipo, double preco, String disponivel) {
        this.numero = numero;
        this.tipo = tipo;
        this.preco = preco;
        this.disponivel = " Disponivel " ;
    }



    @Override
    public String toString() {
        return  " Numero quarto: " + numero + " Tipo " + tipo + " Preço " + preco + " " + disponivel ;
    }




}
