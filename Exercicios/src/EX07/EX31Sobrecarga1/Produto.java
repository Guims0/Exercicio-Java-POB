package EX07.EX31Sobrecarga1;

public class Produto {
    private String nome;
    private double preco;
    private int quantidadeEstoque;

    public Produto(String nome, double preco, int quantidadeEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = 0;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        if (preco < 0){
            System.out.println("O valor nao pode ser menor que zero(0)");
        }else {
            this.preco = preco;
        }
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        if (quantidadeEstoque < 0){
            System.out.println("A quantidade nao pode ser menor que zero(0)");
        }else {
            this.quantidadeEstoque = quantidadeEstoque;
        }
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public double calcularValorTotalEmEstoque(){
        return this.preco * this.quantidadeEstoque;
    }
}
