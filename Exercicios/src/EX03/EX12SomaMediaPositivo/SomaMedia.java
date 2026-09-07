package EX03.EX12SomaMediaPositivo;

import java.util.Scanner;

public class SomaMedia {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = 0 ,soma = 0 ,quantidade = 0;
        double media;

        while (n >= 0) {

            System.out.println("Digite um numero positivo: ");
            n = sc.nextInt();
            
            if(n > 0 ){
                soma += n;
                quantidade ++;
            }
           
        }

        media = soma / quantidade;
        System.out.println("foram digitados "+quantidade+" numeros positivos");
        System.out.println("A soma de todos os numeros positivos foram "+soma);
        System.out.println("A media desses numeros foram: "+media);




        sc.close();
    }
}
