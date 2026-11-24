package EX18.EX90;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pedido {
    private Long id;
    private String cliente;
    private LocalDateTime dataHora = LocalDateTime.now();
    private BigDecimal total = BigDecimal.ZERO;

    public Pedido() {}

    public Pedido(String cliente) {
        this.cliente = cliente;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }
    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }
}
