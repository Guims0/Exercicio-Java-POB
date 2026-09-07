package EX03.EX13ValidacaoSenha;

import java.util.Scanner;

public class ValidaSenha {
    
     public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = 0,senha = 1234;

        while (n != senha) {

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
