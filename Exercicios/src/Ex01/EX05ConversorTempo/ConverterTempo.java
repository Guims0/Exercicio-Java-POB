package Ex01.EX05ConversorTempo;

import java.util.Scanner;

public class ConverterTempo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o total de segundos: ");
        int totalSegundos = sc.nextInt();

        int horas = totalSegundos / 3600;

        int resto = totalSegundos % 3600;

        int minutos = resto / 60;

        int segundos = resto % 60;

        System.out.println(horas + " hora(s), " + minutos + " minuto(s) e " + segundos + " segundo(s)");

        sc.close();

    }
}
