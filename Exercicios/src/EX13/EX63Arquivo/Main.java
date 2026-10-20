package EX13.EX63Arquivo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Path arquivoCsv = Path.of("produtos.csv");

        try {
            List<String> linhas = Files.readAllLines(arquivoCsv);
            double valorTotalInventario = 0.0;

            for (int i = 1; i < linhas.size(); i++) {
                String linha = linhas.get(i);
                if (linha.isBlank()) continue;

                String[] campos = linha.split(",");
                String nome = campos[0].trim();
                int quantidade = Integer.parseInt(campos[1].trim());
                double precoUnitario = Double.parseDouble(campos[2].trim());

                double valorTotalItem = quantidade * precoUnitario;
                valorTotalInventario += valorTotalItem;

                System.out.printf("Item: %s | Qtd: %d | Total Item: R$ %.2f%n", nome, quantidade, valorTotalItem);
            }

            System.out.printf("%nValor Global do Inventário: R$ %.2f%n", valorTotalInventario);

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro na conversão numérica de uma das linhas: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Erro no formato da linha, colunas ausentes: " + e.getMessage());
        }
    }
}
