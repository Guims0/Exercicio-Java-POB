package EX16.EX80;

public class ProcessadorPagamentoService {
    private final GatewayPagamento gateway;
    private final PedidoRepository pedidoRepository;

    public ProcessadorPagamentoService(GatewayPagamento gateway, PedidoRepository pedidoRepository) {
        this.gateway = gateway;
        this.pedidoRepository = pedidoRepository;
    }

    public void processar(Pedido pedido) {
        gateway.cobrar(pedido.getValor());
        pedido.setStatus("PAGO");
        pedidoRepository.atualizar(pedido);
    }
}