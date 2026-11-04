package EX15.EX73;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraEstatistica<T extends Number> {
    private List<T> lista = new ArrayList<>();

    public void adicionar(T numero) {
        lista.add(numero);
    }

    public double calcularMedia() {
        if (lista.isEmpty()) return 0.0;
        double soma = 0.0;
        for (T num : lista) {
            soma += num.doubleValue();
        }
        return soma / lista.size();
    }

    public double calcularMaior() {
        if (lista.isEmpty()) throw new IllegalStateException("A lista está vazia!");
        double maior = lista.get(0).doubleValue();
        for (T num : lista) {
            if (num.doubleValue() > maior) {
                maior = num.doubleValue();
            }
        }
        return maior;
    }

    public static void main(String[] args) {
        CalculadoraEstatistica<Integer> calcInt = new CalculadoraEstatistica<>();
        calcInt.adicionar(10);
        calcInt.adicionar(20);
        System.out.println("Média Int: " + calcInt.calcularMedia());

        CalculadoraEstatistica<Double> calcDouble = new CalculadoraEstatistica<>();
        calcDouble.adicionar(5.5);
        calcDouble.adicionar(10.5);
        System.out.println("Maior Double: " + calcDouble.calcularMaior());
    }
}