import objetos.Hospede;
import objetos.Quarto;
import objetos.Reserva;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static List<Quarto> quartos = new ArrayList<Quarto>();
    public static List<Reserva> reservas = new ArrayList<Reserva>();
    public static List<Hospede> hospedes = new ArrayList<Hospede>();
    public static int contadorQuartos = 1;

    public static void main(String[] args) {
        menu();
    }

    static void menu(){
        int opcao=0;
        while(opcao!=4){
            System.out.println("Digite a opção que deseja: \n" +
                                " [1 cadrastrar quarto ] \n" +
                                " [2 reservar quarto ] \n" +
                                " [3 checkin] \n" +
                                " [4 ver quartos disponiveis ] \n" +
                                " [5 ver Histórico de Reservas ] \n" +
                                " [6 fechar pedido ] \n" +
                                " [7 sair ] \n " );
            opcao=scanner.nextInt();
            switch (opcao){
                case 1:cadastrarQuarto();
                    break;
                case 2:cadastroReserva();
                    break;
                case 3: quartosOcupados();
                    break;
                case 4: quartosDisponiveis(); menu();
                    break;
                case 5 : listaHospede();
                break;
                case 6: checkOut();
                    break;
                    case 7: System.out.println("Até mais!!");
                        break;
                default:System.out.println("Opção inválida. Por favor, escolha uma opção válida.  \n " );
                    break;
            }
        }
    }

    static void cadastrarQuarto(){
        System.out.println("\n Digite o numero do quarto: ");
        int nunQuarto = scanner.nextInt();
        System.out.println("Digite o preço diario do quarto: \n");
        double valorDiario = scanner.nextDouble();
        String tipo = "";
        System.out.println("\nCadastrando Quarto \n");
        System.out.println("Tipo do quarto [ 1 - solteiro ] [ 2 - casal ] [ 3 - suite ] ");
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                tipo  = "Solteiro";
                break;
            case 2:
                tipo  = "Casal";
                break;
            case 3:
                tipo  = "Suite";
                break;
            default:
                System.out.println("Opção inválida. Por favor, escolha uma opção válida (1, 2, ou 3). \n");
                break;
        }
        String disponivel = " Disponivel ";

        Quarto quarto = new Quarto(nunQuarto, tipo, valorDiario, disponivel);
        quartos.add(quarto);

        System.out.println("Quarto cadastrado com sucesso! \n");
    }

    static void cadastroReserva() {
        int quarto = 0;
        String tipoQuarto = " ";

        System.out.println("\nDigite seu nome: ");
        String nome = scanner.next();
        String nomeTo = nome.toLowerCase();
        System.out.print("\nData de Check-in (dd/MM/yyyy): ");
            String dataCheckin = scanner.next();
            LocalDate checkin;

            try (Scanner scanner = new Scanner(dataCheckin)) {
                String datastring = scanner.next();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                checkin =LocalDate.parse(datastring, formatter);
            }
        System.out.print("\nData de Check-out (yyyy/mm/dd): ");
        String dataSaida = scanner.next();
        LocalDate checkout;

        try (Scanner scanner = new Scanner(dataSaida)) {
            String datastring = scanner.next();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            checkout =LocalDate.parse(datastring, formatter);
        }

        System.out.println("Digite o numero do quarto que deseja: \n");
        quartosDisponiveis();
        int quartoPronto = scanner.nextInt();
       for(Quarto q: quartos){
           if(quartoPronto==q.numero){
               if(q.disponivel == " Indisponivel "){
                   System.out.println(" Esse quarto esta indisponivel ou não existe tente novamente");
                   quartosDisponiveis();
               } else {
                   quarto = quartoPronto;
               }
           }
       }

        System.out.println("Digite o horario que deseja: [Manhã, tarde ou noite]: \n");
        String horario = scanner.next();
        String horarioTo = horario.toLowerCase();

        double valorQuarto = 0;
        for (Quarto q : quartos) {
            if (quarto == q.numero) {
                valorQuarto = q.preco;
                tipoQuarto = q.tipo;
                q.disponivel = " Indisponivel ";
            }
        }
        for (Reserva r : reservas) {
            if (Objects.equals(nomeTo, r.nome)) {
                horarioTo = r.horarios;
            }
        }


        Reserva reserva = new Reserva(nomeTo, checkin, checkout, quarto, tipoQuarto, horarioTo);
        reservas.add(reserva);
        Hospede hospede = new Hospede(nomeTo, checkin, checkout, tipoQuarto, valorQuarto, quarto);
        hospedes.add(hospede);


        System.out.println("Reserva Cadastrada com sucesso! \n");
    }

    static void quartosOcupados(){
        System.out.println("---- Quartos ocupados ---- \n");
        for(Reserva reserva: reservas) {
             System.out.println(reserva.toString());
            }
        System.out.println("\n--------------------------");
        menu();
    }
    static void quartosDisponiveis(){
        System.out.println("\n--- Quartos disponiveis --- \n");
        for(Quarto quarto: quartos) {
            if(quarto.disponivel == " Disponivel ") {
                System.out.println(" O quarto com o numero " + quarto.numero + " Do tipo " + quarto.tipo + " com o preço " + quarto.preco+ " está " + quarto.disponivel);
            }
        }
        System.out.println("\n-------------------------- \n");
    }
    static void listaHospede() {
        int quartos = 0;
        System.out.println("\n---- Histórico de Reservas ---- \n");
        Set<String> hospedesA = new HashSet<>();
        for (Hospede hospedes: hospedes) {
           hospedesA.add(hospedes.nome);
        }
        for (String string: hospedesA) {
            System.out.println(string);
        }
        System.out.println( "\n Digite o nome do hospede que deseja ver o historico ou digite sair para sair \n");
        String nome = scanner.next();
        String nomeTo = nome.toLowerCase();

        if(nome.equals("sair")){
            menu();
        }else {


            for (Hospede hospede : hospedes) {
                if (hospede.nome.equals(nomeTo)) {
                    System.out.println(hospede + "\n");
                    quartos++;
                }
            }
            System.out.println(" A quantidade de quartos reservados foi " + quartos);
        }
        listaHospede();
    }

    static void checkOut() {
        System.out.println("\n---- Fechamento de Conta ---- \n");
        System.out.println(" Quartos ocupados \n");
        for (Quarto quarto : quartos) {
            if (quarto.disponivel == " Indisponivel ")
                System.out.println(" Quarto numero: " + quarto.numero + " do tipo " + quarto.tipo);
        }
        System.out.println("\n Digite o numero do quarto que deseja fazer o check out ou [ 0 para retornar para o menu principal ] \n");
        int numero = scanner.nextInt();

        if (numero == 0) {
            return;
        } else {
            for (Hospede hospede : hospedes) {
                if (numero == hospede.quarto) {

                    LocalDate checkInDate = hospede.dataReserva;
                    LocalDate checkOutDate = hospede.dataSaida;
                    long diasEstadia = ChronoUnit.DAYS.between(checkInDate, checkOutDate);

                    System.out.println(" quarto encontrado \n");
                    System.out.println("Você ficou por:  " + diasEstadia + " dias");
                    System.out.println(" o valor total de todos os quarto foi: " + hospede.valorQuarto * diasEstadia);
                    System.out.println(" precione 1 para pagar ou 2 para sair");
                    int opcao = scanner.nextInt();

                    if (opcao == 1) {
                        System.out.println("\nPagamento feito com sucesso até logo");

                        for (Quarto quarto : quartos) {
                            if (numero == quarto.numero) {
                                quarto.disponivel = " Disponivel ";
                            }
                        }
                        reservas.removeIf(reserva -> numero == reserva.quarto);
                        return;
                    } else {
                        System.out.println(" voltando ");
                        return;
                    }
                }
                System.out.println(" O quarto não foi encontrado!!! tente novamente");
                return;
            }
        }
        }
    }


