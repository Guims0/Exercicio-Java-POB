package EX03.EX11Tabuada;

import java.util.Scanner;

public class TabuadaNumero{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n ,n2;

        System.out.println("Digite um numero para exibir sua tabuada até 10: ");
        n = sc.nextInt();
        n2 = 1;
        while (n2 < 11) {
            
            System.out.println(n +" x "+ n2 +" = "+ n*n2);

            n2++;
        }
       


        sc.close();
    }
    
}
