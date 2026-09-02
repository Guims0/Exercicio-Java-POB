package EX08AprovacaoAluno;

import java.util.Scanner;

public class Nota {
     public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a primeira nota : ");
        double n1 = sc.nextDouble();
        System.out.println("Digite a segunda nota : ");
        double n2 = sc.nextDouble();

        double media = (n1 + n2) / 2; 


        if(media >= 7 ){

            System.out.println("Aprovado");
        }else if(media >= 5.0 && media < 7){

            System.out.println("recuperacao");
        }else{

            System.out.println("reprovado");

        }

        sc.close();
    }
}
