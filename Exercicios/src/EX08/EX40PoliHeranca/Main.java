package EX08.EX40PoliHeranca;

public class Main {
    public static void main(String[] args) {
        ContaPoupanca cp = new ContaPoupanca("123", 1000, 1);
        cp.aplicarRendimento();
        System.out.println("Saldo Poupança: R$" + cp.getSaldo());

        ContaCorrente cc = new ContaCorrente("456", 500, 1000);
        cc.sacar(600);
        System.out.println("Saldo Corrente: R$" + cc.getSaldo());
    }
}
