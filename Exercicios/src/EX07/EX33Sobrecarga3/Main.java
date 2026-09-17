package EX07.EX33Sobrecarga3;

public class Main {
    public static void main(String[] args) {
        Retangulo r1 = new Retangulo(5.0, 3.0);
        System.out.println("Área r1: " + r1.calcularArea());
        System.out.println("Perímetro r1: " + r1.calcularPerimetro());

        System.out.println("-------------------------");

        Retangulo r2 = new Retangulo(-2.0, 0);

        System.out.println("Área r2 : " + r2.calcularArea());
        System.out.println("Perímetro r2: " + r2.calcularPerimetro());
    }
}
