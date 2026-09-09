package EX04.EX17MaiorMenor;

import java.util.Scanner;

public class MaiorMenor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] vetor = new int[10];
        int i,maior,menor,indiceMaior = 0,indiceMenor = 0;

        System.out.println("Digite 10 numeros inteiros:");
        for ( i = 0; i < vetor.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            vetor[i] = scanner.nextInt();
        }

        maior = vetor[0];
        menor = vetor[0];

        for (i = 1; i < vetor.length; i++) {
            if (vetor[i] > maior) {
                maior = vetor[i];
                indiceMaior = i;
            }
            if (vetor[i] < menor) {
                menor = vetor[i];
                indiceMenor = i;
            }
        }

        System.out.println("Maior valor: " + maior + "| indice: " + indiceMaior );
        System.out.println("Menor valor: " + menor + "| indice: " + indiceMenor );

        scanner.close();
    }
}
