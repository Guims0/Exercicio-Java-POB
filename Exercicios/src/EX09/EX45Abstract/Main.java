package EX09.EX45Abstract;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static double calcularTotalImpostos(List<Tributavel> itensTributaveis) {
        double total = 0;
        for (Tributavel item : itensTributaveis) {
            total += item.calcularTributo();
        }
        return total;
    }

    public static void main(String[] args) {
        Eletronico tv = new Eletronico(101, 2000);
        Eletronico celular = new Eletronico(102, 1500);
        Alimento arroz = new Alimento(201, 25);

        List<Tributavel> listaTributaveis = new ArrayList<>();
        listaTributaveis.add(tv);
        listaTributaveis.add(celular);

        double totalImpostos = calcularTotalImpostos(listaTributaveis);

        System.out.println("Total de impostos a pagar: R$" + totalImpostos);
    }
}
