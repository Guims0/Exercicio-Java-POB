package EX16.EX78;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository repository;

    @InjectMocks
    private UsuarioService service;

    @Test
    void deveAtualizarEmailESalvarNoRepositorio() {
        Usuario usuarioExistente = new Usuario(1L, "Carlos", "antigo@email.com");
        when(repository.buscarPorId(1L)).thenReturn(Optional.of(usuarioExistente));

        service.atualizarEmail(1L, "novo@email.com");

        assertEquals("novo@email.com", usuarioExistente.getEmail());
        verify(repository, times(1)).salvar(any(Usuario.class));
    }
}