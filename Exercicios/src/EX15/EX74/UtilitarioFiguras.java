package EX15.EX74;

import java.util.Arrays;
import java.util.List;

public class UtilitarioFiguras {

    public static double somarAreas(List<? extends Figura> listaFiguras) {
        double soma = 0;
        
        for (Figura f : listaFiguras) {
            soma += f.calcularArea();
        }
        
        return soma;
    }

    public static void main(String[] args) {
        List<Quadrado> quadrados = Arrays.asList(new Quadrado(2), new Quadrado(4));
        List<Circulo> circulos = Arrays.asList(new Circulo(3));
        
        System.out.println("Área total dos quadrados: " + somarAreas(quadrados));
        System.out.println("Área total dos círculos: " + somarAreas(circulos));
    }
}
