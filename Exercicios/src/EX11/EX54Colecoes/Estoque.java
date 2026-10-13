package EX11.EX54Colecoes;

import java.util.HashMap;
import java.util.Map;

public class Estoque {
    private Map<String, Integer> estoque = new HashMap<>();

    public void inserirProduto(String codigo, int quantidade) {
        if (!estoque.containsKey(codigo)) {
            estoque.put(codigo, quantidade);
            System.out.println("Produto " + codigo + " inserido.");
        } else {
            System.out.println("Produto já existe. Use a atualização de estoque.");
        }
    }

    public void atualizarEstoque(String codigo, int quantidadeAjuste) {
        if (estoque.containsKey(codigo)) {
            int novaQuantidade = estoque.get(codigo) + quantidadeAjuste;
            estoque.put(codigo, Math.max(0, novaQuantidade));
            System.out.println("Estoque de " + codigo + " atualizado para: " + estoque.get(codigo));
        } else {
            System.out.println("Código " + codigo + " não encontrado.");
        }
    }

    public void exibirEstoqueAlerta(int limiteAviso) {
        System.out.println("\n--- Alerta de Estoque Baixo (< " + limiteAviso + ") ---");
        for (Map.Entry<String, Integer> produto : estoque.entrySet()) {
            if (produto.getValue() < limiteAviso) {
                System.out.println("Produto: " + produto.getKey() + " | Quantidade: " + produto.getValue());
            }
        }
    }
}