package EX03CalculoSalario;

import java.util.Scanner;
import java.text.DecimalFormat;


public class Calculo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DecimalFormat dc = new DecimalFormat("#00");


        System.out.println("Qual o valor das suas horas de trabalho?: ");
        double dinheiroHrs = sc.nextDouble();


        System.out.println("Quantas horas voce trabalhou esse mes?: ");
        int hrs = sc.nextInt();


        double salarioBruto = dinheiroHrs * hrs;
        double descontoInss = salarioBruto * 0.1;
        double salarioLiquido = salarioBruto - descontoInss;


        System.out.println("O salario bruto é :"+ dc.format(salarioBruto));
        System.out.println("O desconto do INSS ficou em : "+dc.format(descontoInss));
        System.out.println("O Salario Liquido ficou em : "+dc.format(salarioLiquido));

        sc.close();


    }
}

