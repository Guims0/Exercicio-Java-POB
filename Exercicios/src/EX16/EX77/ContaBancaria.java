package EX16.EX77;

public class ContaBancaria {
    private double saldo;

    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor invalido para deposito");
        }
        this.saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de saque deve ser maior que zero");
        }
        if (valor > this.saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para o saque");
        }
        this.saldo -= valor;
    }

    public double getSaldo() {
        return saldo;
    }
}