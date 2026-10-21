package EXTutorial11;

import EXTutorial11.dominio.Produto;
import EXTutorial11.service.CatalogoService;

public class CatalogoApp {
    public static void main(String[] args) {
        CatalogoService service = new CatalogoService();

        System.out.println("--- 1. Cadastro de Produtos Fora de Ordem de Preço ---");
        service.cadastrar(new Produto("P001", "Teclado Mecânico", 350.00, 15));
        service.cadastrar(new Produto("P002", "Monitor 24 Polegadas", 899.90, 8));
        service.cadastrar(new Produto("P003", "Mouse Gamer", 129.50, 30));
        service.cadastrar(new Produto("P004", "Headset USB", 210.00, 12));

        exibirComIndices(service);

        System.out.println("\n--- 2. Exclusão de Produto Intermediário (P002 - Índice 1) ---");
        boolean removido = service.excluirPorCodigo("P002");
        System.out.println("Produto #P002 removido com sucesso? " + removido);
        System.out.printf("Total de produtos remanescentes: %d%n", service.getTotalProdutos());

        System.out.println("\n--- 3. Ordenação Crescente por Preço via Collections.sort() ---");
        service.ordenarPorPreco();
        exibirComIndices(service);
    }

    private static void exibirComIndices(CatalogoService service) {
        for (int i = 0; i < service.getTotalProdutos(); i++) {
            System.out.printf("Índice [%d] -> %s%n", i, service.obterPorPosicao(i));
        }
    }
}