package EX16.EX76;

public class ValidadorSenha {

    public boolean isForte(String senha) {
        if (senha == null || senha.length() < 8) {
            return false;
        }

        boolean temNumero = false;
        boolean temMaiuscula = false;

        for (char c : senha.toCharArray()) {
            if (Character.isDigit(c)) {
                temNumero = true;
            }
            if (Character.isUpperCase(c)) {
                temMaiuscula = true;
            }
        }

        return temNumero && temMaiuscula;
    }
}