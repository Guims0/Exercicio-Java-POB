package EX01CalculadoraMediaSimples;

import java.util.Scanner;
import java.text.DecimalFormat;


public class Media {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DecimalFormat dc = new DecimalFormat("#.00");


        System.out.println("Digite a primeira nota: ");
        double n1 = sc.nextDouble();
        System.out.println("Digite a segunda nota: ");
        double n2 = sc.nextDouble();
        System.out.println("Digite a terceira nota: ");
        double n3 = sc.nextDouble();


        double resultado = (n1+n2+n3)/3;


        System.out.println("Sua media foi de : "+dc.format(resultado));
        sc.close();
    }
}

