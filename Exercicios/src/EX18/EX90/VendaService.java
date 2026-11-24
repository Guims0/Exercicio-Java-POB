package EX18.EX90;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class VendaService {

    private final PedidoDAO pedidoDAO;
    private final ItemPedidoDAO itemPedidoDAO;

    public VendaService(PedidoDAO pedidoDAO, ItemPedidoDAO itemPedidoDAO) {
        this.pedidoDAO = pedidoDAO;
        this.itemPedidoDAO = itemPedidoDAO;
    }

    public long registrarVenda(Pedido pedido, List<ItemPedido> itens) {
        if (itens == null || itens.isEmpty()) {
            throw new IllegalArgumentException("A venda precisa ter ao menos um item");
        }

        BigDecimal total = BigDecimal.ZERO;
        for (ItemPedido item : itens) {
            total = total.add(item.subtotal());
        }
        pedido.setTotal(total);

        Connection conn = null;
        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(false);

            long pedidoId = pedidoDAO.criarPedido(conn, pedido);
            itemPedidoDAO.salvarItens(conn, pedidoId, itens);

            conn.commit();
            return pedidoId;

        } catch (Exception e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    e.addSuppressed(ex);
                }
            }
            throw new RuntimeException("Venda cancelada (rollback executado): " + e.getMessage(), e);

        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException ignored) {
                }
            }
        }
    }
}