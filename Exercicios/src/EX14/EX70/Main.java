package EX14.EX70;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        boolean simularFalhaPassagem = false;
        ExecutorService executor = Executors.newFixedThreadPool(2);

        System.out.println("Iniciando cotações simultâneas de viagem...");

        CompletableFuture<Double> cotacaoPassagem = CompletableFuture.supplyAsync(() -> {
            System.out.println("[Serviço A] Consultando passagens aéreas...");
            dormir(1200);
            if (simularFalhaPassagem) {
                throw new RuntimeException("Timeout no sistema da companhia aérea");
            }
            System.out.println("[Serviço A] Passagem aérea cotada: R$ 1.450,00");
            return 1450.00;
        }, executor).exceptionally(ex -> {
            System.err.println("[Erro Serviço A] " + ex.getMessage() + ". Aplicando tarifa padrão de contingência.");
            return 1800.00;
        });

        CompletableFuture<Double> cotacaoHospedagem = CompletableFuture.supplyAsync(() -> {
            System.out.println("[Serviço B] Consultando rede hoteleira...");
            dormir(800);
            System.out.println("[Serviço B] Hospedagem cotada: R$ 920,00");
            return 920.00;
        }, executor).exceptionally(ex -> {
            System.err.println("[Erro Serviço B] " + ex.getMessage() + ". Aplicando diária padrão.");
            return 1100.00;
        });

        CompletableFuture<String> pacoteViagemFuture = cotacaoPassagem
            .thenCombine(cotacaoHospedagem, (valorVoo, valorHotel) -> {
                double total = valorVoo + valorHotel;
                return String.format(
                    "Pacote Consolidado -> Voo: R$ %.2f | Hotel: R$ %.2f | Valor Total: R$ %.2f",
                    valorVoo, valorHotel, total
                );
            })
            .exceptionally(ex -> "Não foi possível gerar o pacote de viagem: " + ex.getMessage());

        String resumoPacote = pacoteViagemFuture.join();
        long tempoTotal = System.currentTimeMillis() - inicio;

        System.out.println("\n--- Resultado Final ---");
        System.out.println(resumoPacote);
        System.out.println("Tempo total de execução paralela: " + tempoTotal + " ms");

        executor.shutdown();
    }

    private static void dormir(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
