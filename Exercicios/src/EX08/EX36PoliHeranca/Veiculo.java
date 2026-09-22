package EX08.EX36PoliHeranca;

public class Veiculo {
    private String marca;
    private String modelo;

    public Veiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public void exibirDetalhes() {
        System.out.println("Veículo: " + marca + " " + modelo);
    }
}
