package EX04.EX19BuscaLinear;

import java.util.Scanner;

public class BuscaLinear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] vetor = new int[6];
        int i,n,indiceEncontrado =-1;
        boolean encontrado;

        System.out.println("Preencha o vetor com 6 numeros inteiros:");
        for (i = 0; i < vetor.length; i++) {
            System.out.println("Posicao " + i + ": ");
            vetor[i] = scanner.nextInt();
        }

        System.out.println("Digite o numero de busca: ");
         n = scanner.nextInt();

        encontrado = false;

        for (i = 0; i < vetor.length; i++) {
            if (vetor[i] == n) {
                encontrado = true;
                indiceEncontrado = i;
                break;
            }
        }

        if (encontrado) {
            System.out.println("O numero " + n + " esta presente no vetor no indice " + indiceEncontrado + ".");
        } else {
            System.out.println("O numero " + n + " nao foi encontrado no vetor.");
        }

        scanner.close();
    }
}
