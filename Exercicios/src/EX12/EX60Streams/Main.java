package EX12.EX60Streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = Arrays.asList(
                new Funcionario("João", "TI", 5000.0),
                new Funcionario("Maria", "RH", 4000.0),
                new Funcionario("Carlos", "TI", 7000.0),
                new Funcionario("Ana", "Financeiro", 6000.0)
        );

        Predicate<Funcionario> eDoDepartamentoTI = funcionario -> "TI".equalsIgnoreCase(funcionario.getDepartamento());
        Function<Funcionario, Double> calcularReajuste = funcionario -> funcionario.getSalario() * 1.10;
        Consumer<Double> imprimirSalario = salario -> System.out.printf("Salário reajustado: R$ %.2f%n", salario);

        funcionarios.stream()
                .filter(eDoDepartamentoTI)
                .map(calcularReajuste)
                .forEach(imprimirSalario);
    }
}
