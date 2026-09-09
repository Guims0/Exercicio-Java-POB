package EX04.EX16ArmazenaLer;

import java.util.Scanner;

public class ArmazenaLer {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int [] n = new int[5];
        int i ;

        System.out.println("Digite 5 numeros: ");
        for(i = 0; i < n.length ; i++){
            n[i] = sc.nextInt();
        }
        for(i = n.length-1;i >= 0;i--) System.out.println(n[i]);

        sc.close();
    }
}
