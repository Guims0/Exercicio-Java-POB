package EX01.EX04AreaPerimetro;

import java.util.Scanner;
import java.text.DecimalFormat;


public class Retangulo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DecimalFormat dc = new DecimalFormat("#00");


        System.out.println("Digite a altura do Triangulo: ");
        double altura  = sc.nextDouble();


        System.out.println("Digite a base do triangulo: ");
        double base = sc.nextDouble();


        double area = base * altura;
        double perimetro = 2 * (base + altura);


        System.out.println("A area do triangulo é : "+dc.format(area));
        System.out.println("O perimetro do triangulo é: "+dc.format(perimetro));

        sc.close();



    }
}

