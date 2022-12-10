import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int QtddePrestações = 0;
        double ValorTotalDia = 0;
        Scanner entrada = new Scanner(System.in);
        while (true) {
            System.out.print("Digite o valor em reais da prestação: ");
            double ValorDaPrestação = entrada.nextDouble();
            if (ValorDaPrestação == 0) {
                break;
            }
            System.out.print("Quantos dias está em atraso ?: ");
            int diasAtrasados = entrada.nextInt();

            double valorTotal = Pagamento(ValorDaPrestação, diasAtrasados);

            System.out.println("O valor a ser pago será de R$ " + String.format("%.2f", valorTotal));
            System.out.println("");

            QtddePrestações++;
            ValorTotalDia += valorTotal;
        }

        System.out.println("<<<<<<<<<< Relatorio Diário >>>>>>>>>>>>>>");
        System.out.println("Quantidade de prestações: " + QtddePrestações);
        System.out.println("Valor total de prestações: R$ " + String.format("%.2f", ValorTotalDia));
        System.out.println("");

    }

    public static double Pagamento(double valorPrestacao, double diasAtrasados) {
        double valorAPagar = 0;
        if (diasAtrasados > 0) {
            double percentual = 0.03;
            double juros = 0.001;
            double valorMulta = valorPrestacao + (valorPrestacao * percentual);
            valorAPagar = valorMulta + (valorMulta * juros * diasAtrasados);
        } else {
            return valorPrestacao;
        }
        return valorAPagar;

    }

}