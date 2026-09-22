package EX08.EX39PoliHeranca;

public class Main {
    public static void main(String[] args) {
        FiguraGeometrica[] figuras = {
                new Quadrado(4),
                new Retangulo(2, 5),
                new Circulo(3)
        };

        for (FiguraGeometrica f : figuras) {
            System.out.printf("Área da figura: %.2f\n", f.calcularArea());
        }
    }
}
