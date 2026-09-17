package EX07.EX32Sobrecarga2;

public class Main {
    public static void main(String[] args) {
        ContaBancaria conta1 = new ContaBancaria("12345-6", "Ana Costa");
        System.out.println("Saldo inicial da Ana: R$ " + conta1.getSaldo());
        conta1.depositar(500.0);
        System.out.println("Saldo após depósito: R$ " + conta1.getSaldo());

        ContaBancaria conta2 = new ContaBancaria("98765-4", "Carlos Silva", 1000.0);
        System.out.println("\nSaldo inicial do Carlos: R$ " + conta2.getSaldo());

        System.out.println("\nTentando sacar R$ 1500 da conta do Carlos:");
        conta2.sacar(1500.0);

        System.out.println("Tentando depositar valor negativo:");
        conta2.depositar(-200.0);

        conta2.setTitular("Carlos Eduardo Silva");
        System.out.println("Novo nome do titular da conta 2: " + conta2.getTitular());
    }
}
