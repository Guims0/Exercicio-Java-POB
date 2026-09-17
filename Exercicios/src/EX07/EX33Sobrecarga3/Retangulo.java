package EX07.EX33Sobrecarga3;

public class Retangulo {

    private double largura;
    private double altura;

    public Retangulo(double largura, double altura) {
        this.setLargura(largura);
        this.setAltura(altura);
    }

    public double getLargura() {
        return largura;
    }

    public double getAltura() {
        return altura;
    }

    public void setLargura(double largura) {
        if (largura <= 0){
            this.largura = 1;
            System.out.println("A largura nao pode ser menor ou igual a zero. foi colocado o valor padrao de 1");
        }else{
            this.largura = largura;
        }

    }

    public void setAltura(double altura) {
        if (altura <= 0){
            this.altura = 1;
            System.out.println("A altura nao pode ser menor ou igual a zero. foi colocado o valor padrao de 1");
        }else{
            this.altura = altura;
        }
    }
    public double calcularArea() {
        return this.largura * this.altura;
    }

    public double calcularPerimetro() {
        return 2 * (this.largura + this.altura);
    }
}
