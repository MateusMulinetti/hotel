package objetos;

import java.time.LocalDate;

public class Hospede {
    public String nome;
    public LocalDate dataReserva;
    public LocalDate dataSaida;
    public String tipoQuarto;
    public double valorQuarto;
    public int quarto;


    public Hospede(String nome, LocalDate dataReserva, LocalDate dataSaida, String tipoQuarto, double valorQuarto, int quarto) {
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
