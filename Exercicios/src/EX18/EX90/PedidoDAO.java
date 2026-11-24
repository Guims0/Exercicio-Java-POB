package EX18.EX90;

import java.sql.Connection;

public interface PedidoDAO {
    long criarPedido(Connection conn, Pedido pedido);
}
