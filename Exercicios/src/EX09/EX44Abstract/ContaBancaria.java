package EX09.EX44Abstract;

public abstract class ContaBancaria {
    private String numero;
    private double saldo;

    public ContaBancaria(String numero, double saldoInicial) {
        this.numero = numero;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public double consultarSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumero() {
        return this.numero;
    }

    public abstract void cobrarTaxaMensal();
}
