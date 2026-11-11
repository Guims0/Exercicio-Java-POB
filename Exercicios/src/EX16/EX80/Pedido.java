package EX16.EX80;

public class Pedido {
    private double valor;
    private String status;

    public Pedido(double valor) {
        this.valor = valor;
        this.status = "PENDENTE";
    }

    public double getValor() {
        return valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}