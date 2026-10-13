package EX11.EX53Colecoes;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Frequencia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite uma frase longa:");
        String texto = scanner.nextLine();
        
        String[] palavras = texto.toLowerCase().split("\\s+");
        
        Map<String, Integer> frequencia = new HashMap<>();
        
        for (String palavra : palavras) {
            palavra = palavra.replaceAll("[^a-záàâãéèêíïóôõöúç]", "");
            if (!palavra.isEmpty()) {
                frequencia.put(palavra, frequencia.getOrDefault(palavra, 0) + 1);
            }
        }
        
        System.out.println("\nFrequência das palavras:");
        for (Map.Entry<String, Integer> entrada : frequencia.entrySet()) {
            System.out.println(entrada.getKey() + ": " + entrada.getValue());
        }
        
        scanner.close();
    }
}
