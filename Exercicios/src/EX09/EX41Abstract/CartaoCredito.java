package EX09.EX41Abstract;

public class CartaoCredito implements MetodoPagamento {
    private String numeroCartao;
    private double limite;

    public CartaoCredito(String numeroCartao, double limite) {
        this.numeroCartao = numeroCartao;
        this.limite = limite;
    }

    @Override
    public void processarPagamento(double valor) {
        if (valor <= limite) {
            limite -= valor;
            System.out.println("Pagamento de R$" + valor + " aprovado no cartão.");
        } else {
            System.out.println("Limite insuficiente.");
        }
    }

    @Override
    public String obterDetalhes() {
        return "Cartão: " + numeroCartao + " | Limite disponível: R$" + limite;
    }
}