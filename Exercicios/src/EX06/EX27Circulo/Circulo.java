package EX06.EX27Circulo;

public class Circulo {
    double raio;

    double calcularArea() {
        return Math.PI * Math.pow(raio, 2);
    }

    double calcularPerimetro() {
        return 2 * Math.PI * raio;
    }
}
