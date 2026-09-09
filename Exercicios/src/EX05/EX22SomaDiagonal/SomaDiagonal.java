package EX05.EX22SomaDiagonal;

import java.util.Scanner;

public class SomaDiagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] matriz = new double[4][4];
        double somaDiagonal;
        int i,j;

        System.out.println("Preencher matriz 4x4 (numeros reais)");

        for (i = 0; i < 4; i++) {
            for (j = 0; j < 4; j++) {
                System.out.print("Posiçao [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextDouble();
            }
        }

        System.out.println();

        for (i = 0; i < 4; i++) {
            for (j = 0; j < 4; j++) {

                System.out.printf("%8.2f", matriz[i][j]);;
            }
            System.out.println();
        }

        somaDiagonal = 0;

        for (i = 0; i < 4; i++) {
            somaDiagonal += matriz[i][i];
        }

        System.out.println("\nSoma dos elementos da diagonal principal: " + somaDiagonal);

        scanner.close();
    }
}
