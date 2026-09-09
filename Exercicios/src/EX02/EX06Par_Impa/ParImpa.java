package EX02.EX06Par_Impa;

import java.util.Scanner;

public class ParImpa {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um numero: ");
        int numero = sc.nextInt();

        if(numero % 2 == 0 ){

            System.out.println("O numero "+numero+" é par ");
        }else{

            System.out.println("O numero "+numero+" é impar ");

        }

        sc.close();

    }
}