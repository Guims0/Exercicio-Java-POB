package EX08.EX36PoliHeranca;

public class Carro extends Veiculo {
    private int quantidadePortas;

    public Carro(String marca, String modelo, int quantidadePortas) {
        super(marca, modelo);
        this.quantidadePortas = quantidadePortas;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Portas: " + quantidadePortas);
    }
}