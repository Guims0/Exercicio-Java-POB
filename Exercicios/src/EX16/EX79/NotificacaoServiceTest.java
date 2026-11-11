package EX16.EX79;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class NotificacaoServiceTest {

    @Mock
    private EmailSender emailSender;

    @InjectMocks
    private NotificacaoService service;

    @Captor
    private ArgumentCaptor<String> destinatarioCaptor;

    @Captor
    private ArgumentCaptor<String> assuntoCaptor;

    @Captor
    private ArgumentCaptor<String> corpoCaptor;

    @Test
    void deveEnviarEmailDeBoasVindasComDadosCorretos() {
        Usuario usuario = new Usuario("Guilherme Oliveira", "guilherme@email.com");

        service.notificarBoasVindas(usuario);

        verify(emailSender).enviar(
                destinatarioCaptor.capture(),
                assuntoCaptor.capture(),
                corpoCaptor.capture()
        );

        assertEquals("guilherme@email.com", destinatarioCaptor.getValue());
        assertTrue(assuntoCaptor.getValue().contains("Bem-vindo"));
        assertTrue(corpoCaptor.getValue().contains("Guilherme"));
    }
}