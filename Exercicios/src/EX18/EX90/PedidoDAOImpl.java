package EX18.EX90;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class PedidoDAOImpl implements PedidoDAO {

    @Override
    public long criarPedido(Connection conn, Pedido pedido) {
        String sql = "INSERT INTO pedidos (cliente, data_hora, total) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, pedido.getCliente());
            ps.setTimestamp(2, Timestamp.valueOf(pedido.getDataHora()));
            ps.setBigDecimal(3, pedido.getTotal());
            ps.executeUpdate();

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (!keys.next()) {
                    throw new RuntimeException("Pedido criado sem ID gerado");
                }
                long id = keys.getLong(1);
                pedido.setId(id);
                return id;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar pedido", e);
        }
    }
}
