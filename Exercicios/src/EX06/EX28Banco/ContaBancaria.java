package EX06.EX28Banco;

public class ContaBancaria {
    String titular;
    String numeroConta;
    double saldo = 0;

    void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Deposito de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor de deposito invalido.");
        }
    }

    void sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Falha no saque, saldo insuficiente ou valor inválido.");
        }
    }

    void consultarSaldo() {
        System.out.println("Saldo atual de " + titular + ": R$" + saldo);
    }
}
