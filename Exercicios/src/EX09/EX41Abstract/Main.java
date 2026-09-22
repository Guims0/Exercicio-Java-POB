package EX09.EX41Abstract;

public class Main {
    public static void finalizarCompra(MetodoPagamento metodo, double total) {
        metodo.processarPagamento(total);
        System.out.println(metodo.obterDetalhes());
    }

    public static void main(String[] args) {
        MetodoPagamento cartao = new CartaoCredito("1234-5678-9012-3456", 1500);
        MetodoPagamento pix = new Pix("email@exemplo.com");

        finalizarCompra(cartao, 250);
        System.out.println("---");
        finalizarCompra(pix, 100);
    }
}
