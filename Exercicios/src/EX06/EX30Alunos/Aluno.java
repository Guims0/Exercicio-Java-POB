package EX06.EX30Alunos;

public class Aluno {
    String nome;
    String matricula;
    double nota1;
    double nota2;

    double calcularMedia() {
        return (nota1 + nota2) / 2;
    }

    String verificarAprovacao() {
        if (calcularMedia() > 7) {
            return "Aprovado";
        } else {
            return "Reprovado";
        }
    }

    void imprimirBoletim() {
        System.out.println("Boletim escolar");
        System.out.println("Aluno: " + nome);
        System.out.println("Matricula: " + matricula);
        System.out.println("Media final: " + calcularMedia());
        System.out.println("Situacao: " + verificarAprovacao());
        System.out.println("-----------------------");
    }
}
