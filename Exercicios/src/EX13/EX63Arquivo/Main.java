package EX13.EX63Arquivo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Path caminho = Path.of("produtos.csv");

        try {
            if (!Files.exists(caminho)) {
                String csvInicial = "Nome,Quantidade,PrecoUnitario\n"
                        + "Monitor,5,1200.00\n"
                        + "Teclado,10,150.00\n"
                        + "Mouse,20,80.00\n";
                Files.writeString(caminho, csvInicial);
            }

            List<String> linhas = Files.readAllLines(caminho);
            double valorGlobal = 0;

            for (int i = 1; i < linhas.size(); i++) {
                String linha = linhas.get(i);
                String[] partes = linha.split(",");

                try {
                    String nome = partes[0];
                    int quantidade = Integer.parseInt(partes[1].trim());
                    double preco = Double.parseDouble(partes[2].trim());

                    double totalItem = quantidade * preco;
                    valorGlobal += totalItem;

                    System.out.println(nome + " - Total: R$ " + totalItem);
                } catch (NumberFormatException e) {
                    System.out.println("Erro de formato numerico na linha: " + linha);
                }
            }

            System.out.println("Valor global do inventario: R$ " + valorGlobal);
        } catch (IOException e) {
            System.out.println("Erro ao processar o arquivo CSV: " + e.getMessage());
        }
    }
}