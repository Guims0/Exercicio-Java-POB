package EX06.EX29Funcionarios;

public class Funcionario {
    String nome;
    String cargo;
    double salarioBruto;

    void aplicarAumento(double porcentagem) {
        double valorAumento = salarioBruto * (porcentagem / 100);
        salarioBruto += valorAumento;
    }

    double calcularSalarioLiquido(double descontoImposto) {
        return salarioBruto - descontoImposto;
    }
}
