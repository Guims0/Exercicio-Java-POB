package EX07.EX35Sobrecarga5;

public class Funcionario {

    private String nome;
    private String matricula;
    private double salario;

    public Funcionario(String nome, String matricula, double salario) {
        this.nome = nome;
        this.matricula = matricula;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if(salario > this.salario){
            this.salario = salario;
        }else{
            System.out.println("Não pode ser alterado por ser um valor abaixo do salario atual.");
        }
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void exibirDados(){
        System.out.println("Nome: "+this.nome);
        System.out.println("Matricula: "+this.matricula);
        System.out.println("Salario: "+this.salario);
    }
}
