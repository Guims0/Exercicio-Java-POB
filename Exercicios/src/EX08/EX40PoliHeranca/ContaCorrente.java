package EX08.EX40PoliHeranca;

public class ContaCorrente extends Conta {
    private double limiteChequeEspecial;

    public ContaCorrente(String numero, double saldoInicial, double limiteChequeEspecial) {
        super(numero, saldoInicial);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public void sacar(double valor) {
        double valorComTaxa = valor + 2.00;

        if (getSaldo() + limiteChequeEspecial >= valorComTaxa) {
            setSaldo(getSaldo() - valorComTaxa);
            System.out.println("Saque de R$" + valor + " realizado (Taxa: R$2.00).");
        } else {
            System.out.println("Limite do cheque especial excedido!");
        }
    }
}