package EX06.EX30Alunos;

public class Main {
    public static void main(String[] args) {
        Aluno aluno = new Aluno();
        aluno.nome = "Mariana Costa";
        aluno.matricula = "202301015";
        aluno.nota1 = 9.5;
        aluno.nota2 = 5.5;

        aluno.imprimirBoletim();
    }
}
