package EX09.EX44Abstract;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<ContaBancaria> contas = new ArrayList<>();
        contas.add(new ContaCorrente("111-1", 1000));
        contas.add(new ContaEmpresarial("222-2", 5000));

        for (ContaBancaria conta : contas) {
            conta.cobrarTaxaMensal();
            System.out.println("Conta " + conta.getNumero() + " | Saldo após taxa: R$" + conta.consultarSaldo());
        }
    }
}
