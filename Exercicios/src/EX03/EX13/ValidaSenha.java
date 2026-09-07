package EX03.EX13;

import java.util.Scanner;

public class ValidaSenha {
    
     public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n,senha = 1234;

        System.out.println("Digite a senha: ");
        n = sc.nextInt();

        while (n == senha) {

            System.out.println("Digite a senha: ");
            n = sc.nextInt();

            if(n == senha ){

                System.out.println("Acesso permitido.");

            }else{
                System.out.println("Acesso negado,tente novamente");
            }
        }
       


        sc.close();
    }
    
}
