package EX11.EX52Colecoes;

import java.util.HashSet;
import java.util.Set;

public class Controle {
    public static void main(String[] args) {
        Set<Integer> turmaA = new HashSet<>();
        Set<Integer> turmaB = new HashSet<>();

        turmaA.add(101); turmaA.add(102); turmaA.add(103); turmaA.add(101);
        turmaB.add(103); turmaB.add(104); turmaB.add(105); turmaB.add(103);

        System.out.println("Matrículas Turma A: " + turmaA);
        System.out.println("Matrículas Turma B: " + turmaB);

        Set<Integer> uniao = new HashSet<>(turmaA);
        uniao.addAll(turmaB);
        System.out.println("\nUnião (Todos os alunos): " + uniao);

        Set<Integer> intersecao = new HashSet<>(turmaA);
        intersecao.retainAll(turmaB);
        System.out.println("Interseção (Alunos em ambas as turmas): " + intersecao);
    }
}
