package EX16.EX80;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ProcessadorPagamentoServiceTest {

    @Mock
    private GatewayPagamento gateway;

    @Mock
    private PedidoRepository pedidoRepository;

    @InjectMocks
    private ProcessadorPagamentoService service;

    @Test
    void naoDeveAtualizarPedidoQuandoGatewayRecusarPagamento() {
        Pedido pedido = new Pedido(200.0);
        doThrow(new PagamentoRecusadoException()).when(gateway).cobrar(anyDouble());

        assertThrows(PagamentoRecusadoException.class, () -> service.processar(pedido));

        verify(pedidoRepository, never()).atualizar(any());
    }
}