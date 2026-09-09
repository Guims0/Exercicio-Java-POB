package EX02.EX09MaiorNumero;

import java.util.Scanner;

public class MairoNumero {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[3];
        int i,maior=-99999;
        System.out.println("Digite o primeiro numero : ");
        numeros[0] = sc.nextInt();
        System.out.println("Digite o segundo numero : ");
        numeros[1] = sc.nextInt();
        System.out.println("Digite o terceiro numero : ");
        numeros[2] = sc.nextInt();

        for(i = 0 ; i < numeros.length;i++){

            if (numeros[i] > maior) {
                maior = numeros[i];
            }

        }
        System.err.println("O maior numero é "+maior);


        sc.close();
    }
    
}
