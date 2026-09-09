package EX01.EX02ConversorTemperatura;


import java.util.Scanner;
import java.text.DecimalFormat;


public class Conversor {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DecimalFormat dc = new DecimalFormat("#00");


        System.out.println("Digite o graus em celsius: ");
        double celsius = sc.nextDouble();


        double fahrenheit = (celsius * 1.8) + 32;


        System.out.println("A temperatura em Fahrenheit é : "+dc.format(fahrenheit));
        sc.close();
    }
}

