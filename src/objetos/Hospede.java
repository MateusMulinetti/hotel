package objetos;

public class Hospede {
    public String nome;
    public int dataReserva;
    public int dataSaida;
    public String tipoQuarto;
    public double valorQuarto;
    public int quarto;


    public Hospede(String nome, int dataReserva, int dataSaida, String tipoQuarto, double valorQuarto, int quarto) {
        this.nome = nome;
        this.dataReserva = dataReserva;
        this.dataSaida = dataSaida;
        this.tipoQuarto =  tipoQuarto;
        this.valorQuarto = valorQuarto;
        this.quarto = quarto;
    }

    @Override
    public String toString() {
        return " Seu nome é " + nome + " voce reservou dia " + dataReserva + " o quarto do tipo " + tipoQuarto ;
    }

}
