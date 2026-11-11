package EX13.EX65Arquivo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Path arquivoEntrada = Path.of("clientes_bruto.txt");
        Path arquivoSaida = Path.of("clientes_padronizado.txt");

        try {
            if (!Files.exists(arquivoEntrada)) {
                String nomesBrutos = "   joao silva  \n"
                        + "\n"
                        + " MARIA OLIVEIRA \n"
                        + "  carlos souza\n"
                        + "   \n"
                        + "ana costa   \n";
                Files.writeString(arquivoEntrada, nomesBrutos);
            }

            List<String> nomesPadronizados;

            try (Stream<String> linhas = Files.lines(arquivoEntrada)) {
                nomesPadronizados = linhas
                        .map(linha -> linha.trim())
                        .filter(linha -> !linha.isBlank())
                        .map(linha -> linha.toUpperCase())
                        .toList();
            }

            Files.write(arquivoSaida, nomesPadronizados, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Arquivo padronizado gravado com sucesso: " + arquivoSaida);
        } catch (IOException e) {
            System.out.println("Erro ao processar arquivo de clientes: " + e.getMessage());
        }
    }
}