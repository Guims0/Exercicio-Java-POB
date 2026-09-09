package EX05.EX25MatrizTransporta;

import java.util.Scanner;

public class MatrizTransporta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrizA = new int[2][3];
        int[][] matrizTransposta = new int[3][2];
        int i ,j;

        System.out.println("Preencher matriz (2x3)");
        for (i = 0; i < 2; i++) {
            for (j = 0; j < 3; j++) {
                System.out.print("Valor [" + i + "][" + j + "]: ");
                matrizA[i][j] = scanner.nextInt();

                matrizTransposta[j][i] = matrizA[i][j];
            }
        }

        System.out.println("\nMatriz original");
        for (i = 0; i < 2; i++) {
            for (j = 0; j < 3; j++) {
                System.out.print(matrizA[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("\nMatriz transposta");
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 2; j++) {
                System.out.print(matrizTransposta[i][j] + "\t");
            }
            System.out.println();
        }

        scanner.close();
    }
}
