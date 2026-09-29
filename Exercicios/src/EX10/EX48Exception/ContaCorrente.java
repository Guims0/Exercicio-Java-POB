package EX10.EX48Exception;

public class ContaCorrente {
    private String numero;
    private double saldo;

    public ContaCorrente(String numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor > saldo) {
            throw new SaldoInsuficienteException("Saldo de R$ " + saldo + " é insuficiente para sacar R$ " + valor);
        }
        saldo -= valor;
        System.out.println("Saque de R$ " + valor + " realizado. Saldo atual: R$ " + saldo);
    }
}
