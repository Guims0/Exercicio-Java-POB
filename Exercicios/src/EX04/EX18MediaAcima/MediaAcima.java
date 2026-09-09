package EX04.EX18MediaAcima;

import java.util.Scanner;

public class MediaAcima {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] notas = new double[8];
        double soma = 0;
        int i;

        System.out.println("Digite as notas dos 8 alunos:");
        for ( i = 0; i < notas.length; i++) {
            System.out.print("Aluno " + (i + 1) + ": ");
            notas[i] = scanner.nextDouble();
            soma += notas[i];
        }

        double media = soma / notas.length;
        System.out.printf("\nMédia aritmética da turma: %.2f\n", media);

        System.out.println("Notas acima da média:");
        for ( i = 0; i < notas.length; i++) {
            if (notas[i] > media) {
                System.out.println("Aluno " + (i + 1) + ": " + notas[i]);
            }
        }

        scanner.close();
    }
}
