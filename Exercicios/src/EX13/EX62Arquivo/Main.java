package EX13.EX62Arquivo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Path caminho = Path.of("servidor.log");

        try {
            if (!Files.exists(caminho)) {
                String logsIniciais = "[INFO] Servidor iniciado\n"
                        + "[ERROR] Falha de conexao\n"
                        + "[INFO] Usuario autenticado\n"
                        + "[ERROR] Timeout no banco\n"
                        + "[ERROR] Permissoes insuficientes\n";
                Files.writeString(caminho, logsIniciais);
            }

            try (Stream<String> linhas = Files.lines(caminho)) {
                List<String> erros = linhas
                        .filter(linha -> linha.startsWith("[ERROR]"))
                        .map(linha -> linha.replace("[ERROR]", "").trim())
                        .toList();

                System.out.println("Total de erros encontrados: " + erros.size());
                for (String erro : erros) {
                    System.out.println("- " + erro);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de log: " + e.getMessage());
        }
    }
}