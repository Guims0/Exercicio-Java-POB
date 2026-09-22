package EX09.EX44Abstract;

public class ContaEmpresarial extends ContaBancaria {
    public ContaEmpresarial(String numero, double saldoInicial) {
        super(numero, saldoInicial);
    }

    @Override
    public void cobrarTaxaMensal() {
        double taxa = 30+ (consultarSaldo() * 0.005);
        setSaldo(consultarSaldo() - taxa);
    }
}
