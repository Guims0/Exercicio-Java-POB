package EX10.EX49Exception;

public class Eleitor {

    public void cadastrar(String nome, int idade) {
        if (idade < 0 || idade > 130) {
            throw new IdadeInvalidaException("Idade " + idade + " não é válida para o eleitor " + nome + ".");
        }
        System.out.println("Eleitor " + nome + " cadastrado");
    }
}
