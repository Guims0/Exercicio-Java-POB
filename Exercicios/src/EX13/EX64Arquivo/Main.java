package EX13.EX64Arquivo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Path pastaRaiz = Path.of("src");
        AtomicLong tamanhoTotalBytes = new AtomicLong(0);

        try (Stream<Path> caminhoStream = Files.walk(pastaRaiz)) {
            caminhoStream
                    .filter(Files::isRegularFile)
                    .filter(p -> p.toString().endsWith(".java"))
                    .forEach(caminho -> {
                        try {
                            long tamanho = Files.size(caminho);
                            tamanhoTotalBytes.addAndGet(tamanho);
                            Path relativo = pastaRaiz.relativize(caminho);
                            System.out.printf("Arquivo: %s | Tamanho: %d bytes%n", relativo, tamanho);
                        } catch (IOException e) {
                            System.err.println("Erro ao obter tamanho do arquivo: " + caminho);
                        }
                    });

            System.out.printf("%nTamanho total dos arquivos Java: %d bytes%n", tamanhoTotalBytes.get());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
