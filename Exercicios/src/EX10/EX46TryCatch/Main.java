package EX10.EX46TryCatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite o número a ser dividido : ");
            int num1 = scanner.nextInt();

            System.out.print("Digite o número divisor: ");
            int num2 = scanner.nextInt();

            int resultado = num1 / num2;
            System.out.println("Resultado da divisão: " + resultado);

        } catch (ArithmeticException e) {
            System.out.println(" Não é possível realizar divisão por zero.");
        } catch (InputMismatchException e) {
            System.out.println(" Entrada inválida. Digite apenas números inteiros.");
        } finally {
            System.out.println("Operação finalizada.");
            scanner.close();
        }
    }
}

