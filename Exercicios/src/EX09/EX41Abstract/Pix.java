package EX09.EX41Abstract;

public class Pix implements MetodoPagamento {
    private String chavePix;

    public Pix(String chavePix) {
        this.chavePix = chavePix;
    }

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Pagamento PIX de R$" + valor + " realizado para a chave " + chavePix);
    }

    @Override
    public String obterDetalhes() {
        return "Chave PIX: " + chavePix;
    }
}
