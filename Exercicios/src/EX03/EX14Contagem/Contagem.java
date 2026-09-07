package EX03.EX14Contagem;

import java.util.Scanner;

public class Contagem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n,n2,i,contPar=0,contImpar=0,temp;

        System.out.println("Digite o primeiro numero do intervalo: ");
        n = sc.nextInt();
        System.out.println("Digite o segundo numero do intervalo: ");
        n2 = sc.nextInt();

        if (n > n2) {
            temp = n;
            n = n2;
            n2 = temp;
        }

        for(i = n ; i <= n2 ; i++ ){

            if(i % 2 ==0){
                contPar++;
            }else {
                contImpar++;
            }
        }

        System.out.println("A quantidades de numeros pares: "+contPar);
        System.out.println("A quantidades de numeros impares: "+contImpar);

        sc.close();
    }
}
