package EX06.EX29Funcionarios;

public class Main {
    public static void main(String[] args) {
        Funcionario func = new Funcionario();
        func.nome = "Carlos Eduardo";
        func.cargo = "Desenvolvedor Backend";
        func.salarioBruto = 4000;

        System.out.println("Dados do funcionario");
        System.out.println("Salario original: R$" + func.salarioBruto);

        func.aplicarAumento(10);
        System.out.println("Salario apos aumento de 10%: R$" + func.salarioBruto);

        double salarioLiquido = func.calcularSalarioLiquido(200);
        System.out.println("Salario liquido (desconto): R$" + salarioLiquido);
    }
}
