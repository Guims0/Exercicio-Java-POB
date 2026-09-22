package EX08.EX37PoliHeranca;

public class Vendedor extends Funcionario {
    private double totalVendas;
    private double comissaoPercentual;

    public Vendedor(String nome, double salarioBase, double totalVendas, double comissaoPercentual) {
        super(nome, salarioBase);
        this.totalVendas = totalVendas;
        this.comissaoPercentual = comissaoPercentual;
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + (totalVendas * (comissaoPercentual / 100));
    }
}
