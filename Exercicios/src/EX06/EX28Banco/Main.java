package EX06.EX28Banco;

public class Main {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria();
        conta.titular = "Ana Silva";
        conta.numeroConta = "12345-6";

        System.out.println("Movimentação Bancaria");
        conta.consultarSaldo();

        conta.depositar(600);
        conta.sacar(250);
        conta.consultarSaldo();

        conta.sacar(1000);
        conta.depositar(-150);
    }
}
