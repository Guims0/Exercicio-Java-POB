package EX16.EX77;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContaBancariaTest {

    private ContaBancaria conta;

    @BeforeEach
    void configurarConta() {
        conta = new ContaBancaria(100.0);
    }

    @Test
    void deveLancarExcecaoQuandoSaldoForInsuficiente() {
        SaldoInsuficienteException erro = assertThrows(
                SaldoInsuficienteException.class,
                () -> conta.sacar(150.0)
        );

        assertEquals("Saldo insuficiente para o saque", erro.getMessage());
    }

    @Test
    void deveLancarExcecaoQuandoValorSaqueForNegativoOuZero() {
        IllegalArgumentException erro = assertThrows(
                IllegalArgumentException.class,
                () -> conta.sacar(0)
        );

        assertEquals("Valor de saque deve ser maior que zero", erro.getMessage());
    }
}