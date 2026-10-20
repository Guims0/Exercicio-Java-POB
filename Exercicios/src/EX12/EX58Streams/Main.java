package EX12.EX58Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Aluno> alunos = Arrays.asList(
                new Aluno("Lucas", "Engenharia", 8.5),
                new Aluno("Mariana", "Medicina", 9.0),
                new Aluno("Pedro", "Engenharia", 6.0),
                new Aluno("Sofia", "Direito", 7.5),
                new Aluno("Gabriel", "Medicina", 5.5),
                new Aluno("Carla", "Direito", 4.0)
        );

        Map<String, List<Aluno>> porCurso = alunos.stream()
                .collect(Collectors.groupingBy(Aluno::getCurso));

        Map<Boolean, List<Aluno>> porAprovacao = alunos.stream()
                .collect(Collectors.partitioningBy(aluno -> aluno.getNotaFinal() > 7.0));

        System.out.println("Agrupados por curso:");
        porCurso.forEach((curso, lista) -> System.out.println(curso + ": " + lista));

        System.out.println("\nParticionados por aprovação:");
        System.out.println("Aprovados: " + porAprovacao.get(true));
        System.out.println("Reprovados: " + porAprovacao.get(false));
    }
}
