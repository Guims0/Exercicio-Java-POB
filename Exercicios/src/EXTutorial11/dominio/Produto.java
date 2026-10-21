package EXTutorial11.dominio;

import java.util.Objects;

public class Produto implements Comparable<Produto> {
    private final String codigo;
    private String descricao;
    private double preco;
    private int quantidade;

    public Produto(String codigo, String descricao, double preco, int quantidade) {
        if (codigo == null || codigo.trim().isEmpty() || descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Código e descrição são de fornecimento obrigatório.");
        }
        if (preco < 0) {
            throw new IllegalArgumentException("O preço não pode ser negativo: " + preco);
        }
        if (quantidade < 0) {
            throw new IllegalArgumentException("A quantidade não pode ser negativa: " + quantidade);
        }
        this.codigo = codigo.trim();
        this.descricao = descricao.trim();
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Produto outro = (Produto) obj;
        return Objects.equals(this.codigo, outro.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public int compareTo(Produto outro) {
        return Double.compare(this.preco, outro.preco);
    }

    @Override
    public String toString() {
        return String.format("[%s] %-22s | Preço: R$ %8.2f | Qtd: %3d",
                codigo, descricao, preco, quantidade);
    }
    
}
