package EX13.EX62Arquivo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Path arquivoLog = Path.of("servidor.log");

        try (Stream<String> linhas = Files.lines(arquivoLog)) {
            List<String> erros = linhas
                    .filter(linha -> linha.startsWith("[ERROR]"))
                    .map(linha -> linha.replace("[ERROR]", "").trim())
                    .toList();

            System.out.println("Total de erros encontrados: " + erros.size());
            System.out.println("Mensagens de erro:");
            erros.forEach(msg -> System.out.println("- " + msg));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
