package EX13.EX64Arquivo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Path diretorio = Path.of("Exercicios", "src");
        if (!Files.exists(diretorio)) {
            diretorio = Path.of("src");
        }

        try (Stream<Path> caminhos = Files.walk(diretorio)) {
            List<Path> arquivosJava = caminhos
                    .filter(p -> Files.isRegularFile(p))
                    .filter(p -> p.toString().endsWith(".java"))
                    .toList();

            long somaTotalBytes = 0;

            for (Path arquivo : arquivosJava) {
                long tamanho = Files.size(arquivo);
                somaTotalBytes += tamanho;
                Path caminhoRelativo = diretorio.relativize(arquivo);
                System.out.println(caminhoRelativo + " (" + tamanho + " bytes)");
            }

            System.out.println("Tamanho total dos arquivos Java: " + somaTotalBytes + " bytes");
        } catch (IOException e) {
            System.out.println("Erro ao varrer o diretorio: " + e.getMessage());
        }
    }
}