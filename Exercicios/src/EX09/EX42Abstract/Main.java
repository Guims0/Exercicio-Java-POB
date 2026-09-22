package EX09.EX42Abstract;

public class Main {
    public static void main(String[] args) {
        Forma retangulo = new Retangulo("Azul", 4, 5);
        Forma circulo = new Circulo("Vermelho", 3);

        retangulo.exibirCor();
        System.out.println("Área do Retângulo: " + retangulo.calcularArea());

        System.out.println("---");

        circulo.exibirCor();
        System.out.println("Área do Círculo: " + circulo.calcularArea());
    }
}
