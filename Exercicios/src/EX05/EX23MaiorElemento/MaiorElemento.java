package EX05.EX23MaiorElemento;

import java.util.Scanner;

public class MaiorElemento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matriz = new int[3][4];
        int maiorValor,linhaMaior,colunaMaior,i,j;

        System.out.println("Preencher matriz 3x4");
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 4; j++) {
                System.out.print("Posiçao [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }

        maiorValor = matriz[0][0];
        linhaMaior = 0;
        colunaMaior = 0;

        for (i = 0; i < 3; i++) {
            for (j = 0; j < 4; j++) {
                if (matriz[i][j] > maiorValor) {
                    maiorValor = matriz[i][j];
                    linhaMaior = i;
                    colunaMaior = j;
                }
            }
        }

        System.out.println("Maior elemento: " + maiorValor);
        System.out.println("Localizacao: linha " + linhaMaior + ", coluna " + colunaMaior);

        scanner.close();
    }
}
