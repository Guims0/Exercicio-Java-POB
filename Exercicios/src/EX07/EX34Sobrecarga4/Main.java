package EX07.EX34Sobrecarga4;

public class Main {
    public static void main(String[] args) {
        Carro carro = new Carro("Honda Civic", 2024);

        System.out.println(carro.getModelo());
        System.out.println(carro.isEmMovimento());

        carro.acelerar(40);
        System.out.println(carro.getVelocidadeAtual());
        System.out.println(carro.isEmMovimento());

        carro.acelerar(20);
        System.out.println(carro.getVelocidadeAtual());

        carro.frear(80);
        System.out.println(carro.getVelocidadeAtual());
        System.out.println(carro.isEmMovimento());
    }
}
