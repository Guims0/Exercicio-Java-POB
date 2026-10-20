package EX12.EX57Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Produto> produtos = Arrays.asList(
                new Produto("Notebook", 3500.0),
                new Produto("Mouse", 80.0),
                new Produto("Teclado", 150.0),
                new Produto("Monitor", 1200.0),
                new Produto("Headset", 250.0),
                new Produto("Webcam", 300.0)
        );

        double total = produtos.stream()
                .mapToDouble(Produto::getPreco)
                .sum();

        double media = produtos.stream()
                .mapToDouble(Produto::getPreco)
                .average()
                .orElse(0.0);

        Optional<Produto> produtoMaisCaro = produtos.stream()
                .max(Comparator.comparingDouble(Produto::getPreco));

        System.out.println("Valor total: R$ " + total);
        System.out.println("Preço médio: R$ " + media);
        produtoMaisCaro.ifPresent(p -> System.out.println("Produto mais caro: " + p));
    }
}
