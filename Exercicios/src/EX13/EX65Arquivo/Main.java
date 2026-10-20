package EX13.EX65Arquivo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Path origem = Path.of("clientes_bruto.txt");
        Path destino = Path.of("clientes_padronizado.txt");

        try (Stream<String> linhas = Files.lines(origem)) {
            List<String> clientesTratados = linhas
                    .map(String::trim)
                    .filter(linha -> !linha.isBlank())
                    .map(String::toUpperCase)
                    .toList();

            Files.write(destino, clientesTratados, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Arquivo padronizado gerado com sucesso em " + destino.toAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
