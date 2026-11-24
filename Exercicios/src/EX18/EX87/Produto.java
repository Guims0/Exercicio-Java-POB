package EX18.EX87;

import java.math.BigDecimal;

public class Produto {
    private Long id;
    private String descricao;
    private BigDecimal precoUnitario;
    private int quantidadeEstoque;

    public Produto() {}

    public Produto(String descricao, BigDecimal precoUnitario, int quantidadeEstoque) {
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public BigDecimal getPrecoUnitario() { return precoUnitario; }
    public void setPrecoUnitario(BigDecimal precoUnitario) { this.precoUnitario = precoUnitario; }
    public int getQuantidadeEstoque() { return quantidadeEstoque; }
    public void setQuantidadeEstoque(int quantidadeEstoque) { this.quantidadeEstoque = quantidadeEstoque; }

    @Override
    public String toString() {
        return "Produto{id=" + id + ", descricao='" + descricao + "', precoUnitario=" + precoUnitario
                + ", quantidadeEstoque=" + quantidadeEstoque + "}";
    }
}