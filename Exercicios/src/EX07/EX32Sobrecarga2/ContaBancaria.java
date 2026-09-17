package EX07.EX32Sobrecarga2;

public class ContaBancaria {
    private String numeroConta;
    private String titular;
    private double saldo;

    public ContaBancaria(String titular, String numeroConta) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldo = 0;
    }
    public ContaBancaria(String numeroConta, String titular, double depositoInicial) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.depositar(depositoInicial);
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void depositar (double deposito){
        if (deposito > 0) {
            this.saldo += deposito;
        } else {
            System.out.println("O valor de deposito deve ser maior que zero.");
        }
    }

    public void sacar (double saque){
        if (saque > 0 && this.saldo >= saque) {
            this.saldo -= saque;
        } else if (saque <= 0) {
            System.out.println("O valor de saque deve ser maior que zero.");
        } else {
            System.out.println("Saldo insuficiente para realizar o saque.");
        }
    }
}
