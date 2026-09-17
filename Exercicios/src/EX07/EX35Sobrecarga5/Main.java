package EX07.EX35Sobrecarga5;

public class Main {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("Fernanda Souza", "90123-X", 3500.0);

        funcionario.exibirDados();

        System.out.println("\n--- Atualizando dados ---");
        funcionario.setSalario(3200.0);

        System.out.println("\n--- Atualizando dados ---");
        funcionario.setSalario(4100.0);
        funcionario.setNome("Fernanda Souza Lima");

        funcionario.exibirDados();
    }
}
