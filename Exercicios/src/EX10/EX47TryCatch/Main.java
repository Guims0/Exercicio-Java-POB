package EX10.EX47TryCatch;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] valores = {"1", "5", "aaa", "7"};
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Informe o índice do vetor (0 a 3): ");
            int indice = Integer.parseInt(scanner.nextLine());

            int numero = Integer.parseInt(valores[indice]);
            System.out.println("Valor convertido com sucesso: " + numero);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Índice inexistente. Você tentou acessar uma posição fora do vetor.");
        } catch (NumberFormatException e) {
            System.out.println("A string presente nesta posição não é um número válido para conversão.");
        } finally {
            scanner.close();
        }
    }
}
