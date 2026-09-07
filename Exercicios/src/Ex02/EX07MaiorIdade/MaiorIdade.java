package Ex02.EX07MaiorIdade;

import java.util.Scanner;

public class MaiorIdade {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o ano que voce nasceu: ");
        int ano = sc.nextInt();
        int anoAtual = 2026;

        int idade = anoAtual - ano;


        if(idade >= 18 ){

            System.out.println("Voce deve ter "+idade+" anos e ja é maior de idade");
        }else{

            System.out.println("Voce deve ter "+idade+" anos e não é maior de idade");


        }

        sc.close();
    }
}