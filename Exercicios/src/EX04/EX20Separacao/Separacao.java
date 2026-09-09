package EX04.EX20Separacao;

import java.util.Scanner;

public class Separacao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] original = new int[10];
        int[] pares = new int[10];
        int[] impares = new int[10];
        int i, contPares = 0, contImpares = 0;

        System.out.println("Digite 10 numeros inteiros:");
        for (i = 0; i < original.length; i++) {
            System.out.print("Numero " + (i + 1) + ": ");
            original[i] = scanner.nextInt();

            if (original[i] % 2 == 0) {
                pares[contPares] = original[i];
                contPares++;
            } else {
                impares[contImpares] = original[i];
                contImpares++;
            }
        }

        System.out.println("Vetor de pares (" + contPares + " elementos):");
        for (i = 0; i < contPares; i++) {
            System.out.print(pares[i] + " ");
        }

        System.out.println("\nVetor de impares (" + contImpares + " elementos):");
        for (i = 0; i < contImpares; i++) {
            System.out.print(impares[i] + " ");
        }

        scanner.close();
    }
}
