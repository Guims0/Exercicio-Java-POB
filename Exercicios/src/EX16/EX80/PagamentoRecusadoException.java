package EX16.EX80;

public class PagamentoRecusadoException extends RuntimeException {
    public PagamentoRecusadoException() {
        super("Pagamento recusado");
    }
}