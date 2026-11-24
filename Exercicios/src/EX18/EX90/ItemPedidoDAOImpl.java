package EX18.EX90;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ItemPedidoDAOImpl implements ItemPedidoDAO {

    @Override
    public void salvarItens(Connection conn, long pedidoId, List<ItemPedido> itens) {
        String sql = "INSERT INTO itens_pedido (pedido_id, produto_id, quantidade, preco_unitario) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            for (ItemPedido item : itens) {
                ps.setLong(1, pedidoId);
                ps.setLong(2, item.getProdutoId());
                ps.setInt(3, item.getQuantidade());
                ps.setBigDecimal(4, item.getPrecoUnitario());
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar itens do pedido " + pedidoId, e);
        }
    }
}
