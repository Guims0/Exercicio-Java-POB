package EX10.EX49Exception;

public class Main {
    public static void main(String[] args) {
        Eleitor eleitor = new Eleitor();

        try {
            eleitor.cadastrar("Guilherme", 22);
            eleitor.cadastrar("Matusalém", 150);
        } catch (IdadeInvalidaException e) {
            System.out.println("Falha no cadastro: " + e.getMessage());
        }
    }
}
