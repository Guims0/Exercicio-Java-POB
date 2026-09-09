package EX05.EX24SomaLinha;

import java.util.Scanner;

public class SomaLinha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matriz = new int[4][3];
        int[] vetorSomas = new int[4];
        int i,j,soma;

        System.out.println("Preencher matriz 4x3");

        for (i = 0; i < 4; i++) {
            for (j = 0; j < 3; j++) {
                System.out.print("Digite o valor para a posição [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }

        for (i = 0; i < 4; i++) {
            soma = 0;

            for (j = 0; j < 3; j++) {
                soma += matriz[i][j];
            }

            vetorSomas[i] = soma;
        }

        for (i = 0; i < 4; i++) {
            System.out.println("Soma da linha " + i + ": " + vetorSomas[i]);
        }

        scanner.close();
    }
}
