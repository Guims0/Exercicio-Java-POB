package EX17.EX85;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

    public static void transferirFundos(Connection conn, Long idOrigem, Long idDestino, double valor) {
        String sqlDebito = "UPDATE contas SET saldo = saldo - ? WHERE id = ?";
        String sqlCredito = "UPDATE contas SET saldo = saldo + ? WHERE id = ?";

        try {
            conn.setAutoCommit(false);

            try (PreparedStatement pstmtDebito = conn.prepareStatement(sqlDebito)) {
                pstmtDebito.setDouble(1, valor);
                pstmtDebito.setLong(2, idOrigem);
                pstmtDebito.executeUpdate();
            }

            if (valor > 1000.0) {
                throw new SQLException("Falha simulada: Saldo insuficiente para transferencia.");
            }

            try (PreparedStatement pstmtCredito = conn.prepareStatement(sqlCredito)) {
                pstmtCredito.setDouble(1, valor);
                pstmtCredito.setLong(2, idDestino);
                pstmtCredito.executeUpdate();
            }

            conn.commit();
            System.out.println("Transferencia de R$ " + valor + " concluida com sucesso (Commit realizado).");

        } catch (SQLException e) {
            System.out.println("Erro na transferencia: " + e.getMessage());
            try {
                conn.rollback();
                System.out.println("Transacao desfeita com sucesso (Rollback realizado).");
            } catch (SQLException ex) {
                System.out.println("Erro ao realizar rollback: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        Connection conn = criarConexaoSimulada();

        transferirFundos(conn, 1L, 2L, 250.0);
        transferirFundos(conn, 1L, 2L, 5000.0);
    }

    private static Connection criarConexaoSimulada() {
        PreparedStatement pstmt = (PreparedStatement) Proxy.newProxyInstance(
                PreparedStatement.class.getClassLoader(),
                new Class[]{PreparedStatement.class},
                (proxy, method, args) -> {
                    if (method.getName().equals("executeUpdate")) return 1;
                    return null;
                }
        );

        return (Connection) Proxy.newProxyInstance(
                Connection.class.getClassLoader(),
                new Class[]{Connection.class},
                (proxy, method, args) -> {
                    if (method.getName().equals("prepareStatement")) return pstmt;
                    return null;
                }
        );
    }
}
