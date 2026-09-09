package EX02.EX10Triangulo;

import java.util.Scanner;

public class ClassificacaoTri {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n1,n2,n3;
        System.out.println("Digite o primeiro lado do triangulo : ");
        n1 = sc.nextInt();
        System.out.println("Digite o segundo lado do triangulo : ");
        n2 = sc.nextInt();
        System.out.println("Digite o terceiro lado do triangulo : ");
        n3 = sc.nextInt();

        if(n1 + n2 > n3 && n1 + n3 > n2 && n2 + n3 > n1){

            if(n1 == n2 && n2 == n3){

                System.out.println("é um triangulo Equilátero");

            }else if (n1 == n2 || n1 == n3 || n2 == n3){

                System.out.println("é um triangulo Isósceles");

            }else{

                System.out.println("é um triangulo Escaleno");

            }

        }else{
            System.out.println("não é triangulo");
        }


        sc.close();
    }
    
}
