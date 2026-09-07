package EX03.EX15Fatorial;

import java.util.Scanner;

public class CalculoFatorial {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n ,i = 1;
        double soma = 1;

        System.out.println("Digite um numero positivo para saber seu fatorial: ");
        n = sc.nextInt();
        if(n < 0){
            System.out.println("Não pode numero negativo. Tente novamente");
        }else{
            while (i <= n) {
                soma *= i;
                i++;
            }
            System.out.println("O fatorial de "+n+"! é "+soma);
        }

        sc.close();
    }
}
