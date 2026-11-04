package EX15.EX71;

public class Caixa<T> {
    private T conteudo;

    public void guardar(T elemento) {
        this.conteudo = elemento;
    }

    public T recuperar() {
        return this.conteudo;
    }

    public boolean isVazia() {
        return this.conteudo == null;
    }

    public void limpar() {
        this.conteudo = null;
    }

    public static void main(String[] args) {
        Caixa<Integer> caixaInt = new Caixa<>();
        caixaInt.guardar(42);
        System.out.println("Inteiro: " + caixaInt.recuperar());
        
        Caixa<String> caixaString = new Caixa<>();
        caixaString.guardar("Generics em Java");
        System.out.println("String: " + caixaString.recuperar());
        
        class Produto {
            String nome;
            Produto(String nome) { this.nome = nome; }
            @Override public String toString() { return nome; }
        }
        
        Caixa<Produto> caixaProduto = new Caixa<>();
        caixaProduto.guardar(new Produto("Notebook"));
        System.out.println("Produto: " + caixaProduto.recuperar());
    }
}