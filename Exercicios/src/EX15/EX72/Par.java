package EX15.EX72;

import java.util.Objects;

public class Par<K, V> {
    private final K chave;
    private final V valor;

    public Par(K chave, V valor) {
        this.chave = chave;
        this.valor = valor;
    }

    public K getChave() { return chave; }
    
    public V getValor() { return valor; }

    @Override
    public String toString() {
        return "[Chave: " + chave + ", Valor: " + valor + "]";
    }

    public static <K, V> boolean saoIguais(Par<K, V> p1, Par<K, V> p2) {
        return Objects.equals(p1.getChave(), p2.getChave()) && 
               Objects.equals(p1.getValor(), p2.getValor());
    }

    public static void main(String[] args) {
        Par<Integer, String> p1 = new Par<>(1, "Ativo");
        Par<Integer, String> p2 = new Par<>(1, "Ativo");
        Par<Integer, String> p3 = new Par<>(2, "Inativo");

        System.out.println(p1.toString());
        System.out.println("p1 e p2 são iguais? " + Par.saoIguais(p1, p2));
        System.out.println("p1 e p3 são iguais? " + Par.saoIguais(p1, p3));
    }
}
