package EX08.EX37PoliHeranca;

public class Main {
    public static void main(String[] args) {
        Funcionario[] funcionarios = new Funcionario[3];
        funcionarios[0] = new Funcionario("Ana", 2000.0);
        funcionarios[1] = new Gerente("Carlos", 4000.0, 1500.0);
        funcionarios[2] = new Vendedor("Maria", 1500.0, 10000.0, 5.0);

        double folhaTotal = 0;

        for (Funcionario f : funcionarios) {
            System.out.println(f.getNome() + " recebe: R$ " + f.calcularSalario());
            folhaTotal += f.calcularSalario();
        }

        System.out.println("Total da Folha: R$ " + folhaTotal);
    }
}
