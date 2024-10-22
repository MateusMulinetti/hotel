package objetos;

public class Reserva {
    public String nome;
    public int dataentrada;
    public int datasaida;
    public int quarto;
    public String tipo;
    public String horarios;



    public Reserva(String nome , int dataentrada, int datasaida, int quarto, String tipo, String horarios) {
        this.nome = nome;
        this.dataentrada = dataentrada;
        this.datasaida = datasaida;
        this.quarto = quarto;
        this.tipo = tipo;
        this.horarios = horarios;



    }

    @Override
    public String toString() {
        return  " 0 cliente " + nome + " entrou no dia  " + dataentrada + " e sairá no dia  " + datasaida + " está no quarto numero " + quarto + " do tipo " + tipo + " no periodo da " + horarios;
    }
}
