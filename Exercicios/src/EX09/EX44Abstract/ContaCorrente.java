package EX09.EX44Abstract;

public class ContaCorrente extends ContaBancaria {
    public ContaCorrente(String numero, double saldoInicial) {
        super(numero, saldoInicial);
    }

    @Override
    public void cobrarTaxaMensal() {
        setSaldo(consultarSaldo() - 15.00);
    }
}
