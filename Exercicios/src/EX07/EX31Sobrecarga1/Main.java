package EX07.EX31Sobrecarga1;

public class Main {
    public static void main(String[] args) {
        Produto produtoA = new Produto("Notebook", 3500.00, 10);
        System.out.println("Total em estoque produto A: R$ " + produtoA.calcularValorTotalEmEstoque());

        Produto produtoB = new Produto("Mouse", 150.00);
        System.out.println("Total em estoque produto B: R$ " + produtoB.calcularValorTotalEmEstoque());

        System.out.println("Tentando alterar preço para -10:");
        produtoA.setPreco(-10);
        System.out.println("Tentando alterar quantidade para -20:");
        produtoA.setQuantidadeEstoque(-20);

        System.out.println("Preço atual do Produto A: R$ " + produtoA.getPreco());
        System.out.println("Quantidade atual do Produto B: " + produtoB.getQuantidadeEstoque());

    }
}
