package EX16.EX76;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidadorSenhaTest {

    private final ValidadorSenha validador = new ValidadorSenha();

    @ParameterizedTest
    @ValueSource(strings = {"Senha123", "Segura2026", "Abcdefg1", "TesteForte99"})
    void deveValidarSenhasFortes(String senha) {
        assertTrue(validador.isForte(senha));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"Curta1", "semmaiuscula123", "SEMNUMEROS", "12345678"})
    void deveRejeitarSenhasInvalidas(String senha) {
        assertFalse(validador.isForte(senha));
    }
}