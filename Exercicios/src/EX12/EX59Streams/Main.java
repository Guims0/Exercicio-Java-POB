package EX12.EX59Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static List<String> processarLista(List<String> lista, TransformadorTexto regra) {
        List<String> resultado = new ArrayList<>();
        for (String item : lista) {
            resultado.add(regra.transformar(item));
        }
        return resultado;
    }

    public static void main(String[] args) {
        List<String> palavras = Arrays.asList("java", "stream", "lambda");

        List<String> invertidas = processarLista(palavras, texto -> new StringBuilder(texto).reverse().toString());
        List<String> comColchetes = processarLista(palavras, texto -> "[" + texto + "]");
        List<String> emMaiusculo = processarLista(palavras, String::toUpperCase);

        System.out.println("Invertidas: " + invertidas);
        System.out.println("Com Colchetes: " + comColchetes);
        System.out.println("Em Maiúsculo: " + emMaiusculo);
    }
}
