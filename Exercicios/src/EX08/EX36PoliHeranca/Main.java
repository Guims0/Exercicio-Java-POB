package EX08.EX36PoliHeranca;

public class Main {
    public static void main(String[] args) {
        Carro carro = new Carro("Ford", "Fiesta", 4);
        Moto moto = new Moto("Honda", "CB 500", 500);

        carro.exibirDetalhes();
        System.out.println("---");
        moto.exibirDetalhes();
    }
}
