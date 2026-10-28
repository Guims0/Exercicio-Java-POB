package EX14.EX68;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    static class TarefaDownload implements Callable<String> {
        private final int idArquivo;

        public TarefaDownload(int idArquivo) {
            this.idArquivo = idArquivo;
        }

        @Override
        public String call() throws Exception {
            int tempoPausa = ThreadLocalRandom.current().nextInt(500, 1501);
            String nomeThread = Thread.currentThread().getName();
            
            System.out.printf("Iniciando download do Arquivo %d na %s (tempo estimado: %d ms)%n", 
                    idArquivo, nomeThread, tempoPausa);
            
            Thread.sleep(tempoPausa);
            
            return "Arquivo " + idArquivo + " processado pela thread: " + nomeThread;
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<String>> resultadosFuturos = new ArrayList<>();

        try {
            for (int i = 1; i <= 6; i++) {
                Callable<String> tarefa = new TarefaDownload(i);
                Future<String> futuro = executor.submit(tarefa);
                resultadosFuturos.add(futuro);
            }

            System.out.println("\n--- Coletando resultados dos downloads ---");
            for (Future<String> futuro : resultadosFuturos) {
                try {
                    String resultado = futuro.get();
                    System.out.println("Concluído -> " + resultado);
                } catch (InterruptedException | ExecutionException e) {
                    System.err.println("Erro ao processar download: " + e.getMessage());
                }
            }
        } finally {
            executor.shutdown();
            System.out.println("Pool de threads encerrado com sucesso.");
        }
    }
}
