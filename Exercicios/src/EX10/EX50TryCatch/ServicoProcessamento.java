package EX10.EX50TryCatch;

import java.io.IOException;

public class ServicoProcessamento {
    public void processarArquivo(String caminho) throws ProcessamentoDadosException {
        try {
            if (caminho == null || caminho.isEmpty()) {
                throw new IOException("O caminho para o arquivo está vazio ou nulo.");
            }
            System.out.println("Processando o arquivo : " + caminho);

        } catch (IOException e) {
            throw new ProcessamentoDadosException("Falha no processamento dos dados.", e);
        }
    }
}
