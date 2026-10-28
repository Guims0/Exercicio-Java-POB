package EX14.EX67;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
static class ContadorAcessos {
        private int contadorInseguro = 0;
        private int contadorSincronizado = 0;
        private final AtomicInteger contadorAtomico = new AtomicInteger(0);

        public void incrementarInseguro() {
            contadorInseguro++;
        }

        public synchronized void incrementarSincronizado() {
            contadorSincronizado++;
        }

        public void incrementarAtomico() {
            contadorAtomico.incrementAndGet();
        }

        public int getContadorInseguro() { return contadorInseguro; }
        public int getContadorSincronizado() { return contadorSincronizado; }
        public int getContadorAtomico() { return contadorAtomico.get(); }
    }

    public static void main(String[] args) throws InterruptedException {
        ContadorAcessos contador = new ContadorAcessos();
        int numThreads = 5;
        int incrementosPorThread = 100000;
        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < incrementosPorThread; j++) {
                    contador.incrementarInseguro();
                }
                for (int j = 0; j < incrementosPorThread; j++) {
                    contador.incrementarSincronizado();
                    contador.incrementarAtomico();
                }
            });
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("Resultado esperado: " + (numThreads * incrementosPorThread));
        System.out.println("1. Sem sincronização (Race Condition): " + contador.getContadorInseguro());
        System.out.println("2. Com método synchronized:            " + contador.getContadorSincronizado());
        System.out.println("3. Com AtomicInteger:                  " + contador.getContadorAtomico());
    }
}
