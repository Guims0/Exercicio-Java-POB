package EX11.EX54Colecoes;

public class Main {
    public static void main(String[] args) {
        Estoque sistema = new Estoque();
        
        sistema.inserirProduto("PROD001", 50);
        sistema.inserirProduto("PROD002", 3);
        sistema.inserirProduto("PROD003", 10);
        
        sistema.atualizarEstoque("PROD001", -10);
        sistema.atualizarEstoque("PROD003", -10);
        sistema.atualizarEstoque("PROD004", 5);
        
        sistema.exibirEstoqueAlerta(5);
    }
}
