package EX11.EX55Colecoes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Produto> listaProdutos = new ArrayList<>();
        listaProdutos.add(new Produto("Notebook", "Informática", 3500.00));
        listaProdutos.add(new Produto("Mouse", "Informática", 120.00));
        listaProdutos.add(new Produto("Arroz", "Alimentos", 25.00));
        listaProdutos.add(new Produto("Feijão", "Alimentos", 8.00));
        listaProdutos.add(new Produto("O Senhor dos Anéis", "Livros", 150.00));
        listaProdutos.add(new Produto("1984", "Livros", 45.00));

        Map<String, List<Produto>> produtosAgrupados = new HashMap<>();

        for (Produto p : listaProdutos) {
            produtosAgrupados.putIfAbsent(p.categoria, new ArrayList<>());
            produtosAgrupados.get(p.categoria).add(p);
        }

        for (Map.Entry<String, List<Produto>> entry : produtosAgrupados.entrySet()) {
            System.out.println("Categoria: [" + entry.getKey() + "]");
            for (Produto p : entry.getValue()) {
                System.out.println("  -> " + p);
            }
            System.out.println();
        }
    }
}
