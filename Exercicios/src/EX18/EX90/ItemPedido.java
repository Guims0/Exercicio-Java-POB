package EX18.EX90;

import java.math.BigDecimal;

public class ItemPedido {
    private long produtoId;
    private int quantidade;
    private BigDecimal precoUnitario;

    public ItemPedido() {}

    public ItemPedido(long produtoId, int quantidade, BigDecimal precoUnitario) {
        this.produtoId = produtoId;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public long getProdutoId() { return produtoId; }
    public void setProdutoId(long produtoId) { this.produtoId = produtoId; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    public BigDecimal getPrecoUnitario() { return precoUnitario; }
    public void setPrecoUnitario(BigDecimal precoUnitario) { this.precoUnitario = precoUnitario; }

    public BigDecimal subtotal() {
        return precoUnitario.multiply(BigDecimal.valueOf(quantidade));
    }
}