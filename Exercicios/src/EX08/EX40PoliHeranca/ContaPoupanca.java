package EX08.EX40PoliHeranca;

public class ContaPoupanca extends Conta {
    private double taxaRendimento;

    public ContaPoupanca(String numero, double saldoInicial, double taxaRendimento) {
        super(numero, saldoInicial);
        this.taxaRendimento = taxaRendimento;
    }

    public void aplicarRendimento() {
        double rendimento = getSaldo() * (taxaRendimento / 100);
        depositar(rendimento);
    }
}
