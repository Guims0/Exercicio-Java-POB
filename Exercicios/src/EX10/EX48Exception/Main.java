package EX10.EX48Exception;

public class Main {
    public static void main(String[] args) {
        ContaCorrente conta = new ContaCorrente("12345-X", 500.00);

        try {
            conta.sacar(100);
            conta.sacar(600);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro na operação: " + e.getMessage());
        }
    }
}
