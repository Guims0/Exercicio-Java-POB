package EX14.EX66;

public class Main {
    static class ContadorCrescente implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 1; i <= 10; i++) {
                    System.out.println("[Crescente]  -> " + i);
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Contador crescente interrompido.");
            }
        }
    }

    static class ContadorRegressivo implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 10; i >= 1; i--) {
                    System.out.println("[Regressivo] -> " + i);
                    Thread.sleep(300);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Contador regressivo interrompido.");
            }
        }
    }

    public static void main(String[] args) {
        Thread threadCrescente = new Thread(new ContadorCrescente(), "Thread-Crescente");
        Thread threadRegressiva = new Thread(new ContadorRegressivo(), "Thread-Regressiva");

        System.out.println("Iniciando contagens paralelas...");
        
        threadCrescente.start();
        threadRegressiva.start();

        try {
            threadCrescente.join();
            threadRegressiva.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Contagens finalizadas!");
    }
}
