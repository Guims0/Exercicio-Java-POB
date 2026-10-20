package EX13.EX61Arquivo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Path diretorio = Path.of("dados", "relatorios");
        Path arquivo = diretorio.resolve("sumario.txt");

        try {
            if (Files.notExists(diretorio)) {
                Files.createDirectories(diretorio);
            }

            String conteudo = """
                === RELATÓRIO DE EXECUÇÃO ===
                Data/Hora: %s
                Status: Sucesso
                Sistema em operação normal.
                """.formatted(LocalDateTime.now());

            Files.writeString(arquivo, conteudo, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

            System.out.println("Arquivo criado em " + arquivo.toAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
