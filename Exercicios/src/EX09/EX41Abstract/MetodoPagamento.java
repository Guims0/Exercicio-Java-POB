package EX09.EX41Abstract;

public interface MetodoPagamento {
    void processarPagamento(double valor);
    String obterDetalhes();
}