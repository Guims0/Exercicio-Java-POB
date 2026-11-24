package EX18.EX90;

import java.sql.Connection;
import java.util.List;

public interface ItemPedidoDAO {
    void salvarItens(Connection conn, long pedidoId, List<ItemPedido> itens);
}