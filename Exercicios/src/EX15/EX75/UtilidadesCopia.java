package EX15.EX75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UtilidadesCopia {

    public static <T> void copiarElementos(List<? extends T> origem, List<? super T> destino) {
        for (T elemento : origem) {
            destino.add(elemento); 
        }
    }

    public static void main(String[] args) {
        List<Integer> origemInteiros = Arrays.asList(1, 2, 3);
        
        List<Number> destinoNumeros = new ArrayList<>();
        destinoNumeros.add(0.5);
        copiarElementos(origemInteiros, destinoNumeros);
        System.out.println("Destino Number após cópia: " + destinoNumeros);
        
        List<Object> destinoObjetos = new ArrayList<>();
        destinoObjetos.add("Texto Aleatório");
        copiarElementos(origemInteiros, destinoObjetos);
        System.out.println("Destino Object após cópia: " + destinoObjetos);
    }
}
