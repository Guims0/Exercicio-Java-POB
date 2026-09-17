package EX07.EX34Sobrecarga4;

public class Carro {

    private String modelo;
    private int ano;
    private int velocidadeAtual;

    public Carro(String modelo, int ano) {
        this.modelo = modelo;
        this.ano = ano;
        this.velocidadeAtual = 0;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public int getVelocidadeAtual() {
        return velocidadeAtual;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void acelerar(int incremento){
        if(incremento > 0){
            this.velocidadeAtual += incremento;
        }else {
            System.out.println("Valor invalido");
        }
    }
    public void frear(int decremento){
        if(decremento > 0){
            this.velocidadeAtual -= decremento;
            if(this.velocidadeAtual < 0){
                this.velocidadeAtual = 0;
            }
        }else {
            System.out.println("Valor invalido");
        }
    }

    public boolean isEmMovimento(){
        return this.velocidadeAtual > 0;
    }
}
