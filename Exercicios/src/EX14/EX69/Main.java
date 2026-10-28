package EX14.EX69;

import java.util.concurrent.CompletableFuture;

public class Main {
    static class Pedido {
        int id;
        String clienteEmail;
        double valorProdutos;
        double valorTotalComFrete;

        public Pedido(int id, String clienteEmail, double valorProdutos) {
            this.id = id;
            this.clienteEmail = clienteEmail;
            this.valorProdutos = valorProdutos;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int idPedido = 1042;

        System.out.println("[Main] Disparando pipeline de checkout do pedido #" + idPedido);

        CompletableFuture<Void> pipelineCheckout = CompletableFuture
            .supplyAsync(() -> {
                System.out.println("[Worker] 1. Buscando pedido #" + idPedido + " no banco de dados...");
                dormir(1000);
                return new Pedido(idPedido, "cliente@exemplo.com.br", 250.00);
            })
            .thenApply(pedido -> {
                System.out.println("[Worker] 2. Calculando frete para o pedido #" + pedido.id + "...");
                dormir(400);
                double frete = 25.90;
                pedido.valorTotalComFrete = pedido.valorProdutos + frete;
                return pedido;
            })
            .thenAccept(pedido -> {
                System.out.println("[Worker] 3. Enviando e-mail para " + pedido.clienteEmail + "...");
                dormir(300);
                System.out.printf("[Worker] SUCESSO! Pedido #%d finalizado. Total c/ frete: R$ %.2f%n",
                        pedido.id, pedido.valorTotalComFrete);
            });

        for (int i = 1; i <= 4; i++) {
            System.out.println("[Main] Executando outras ações na interface/servidor... (" + i + "/4)");
            Thread.sleep(400);
        }

        pipelineCheckout.join();
        System.out.println("[Main] Programa finalizado.");
    }

    private static void dormir(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
