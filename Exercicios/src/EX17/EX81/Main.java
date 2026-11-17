package EX17.EX81;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void inserirCliente(Connection conn, String nome, String email) {
        String sql = "INSERT INTO clientes (nome, email) VALUES (?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, nome);
            pstmt.setString(2, email);

            int linhasAfetadas = pstmt.executeUpdate();

            if (linhasAfetadas > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        long idGerado = rs.getLong(1);
                        System.out.println("Cliente inserido com sucesso! ID gerado: " + idGerado);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir cliente: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Connection conn = criarConexaoSimulada();
        inserirCliente(conn, "Guilherme", "guilherme@email.com");
    }

    private static Connection criarConexaoSimulada() {
        ResultSet rs = (ResultSet) Proxy.newProxyInstance(
                ResultSet.class.getClassLoader(),
                new Class[]{ResultSet.class},
                (proxy, method, args) -> {
                    if (method.getName().equals("next")) return true;
                    if (method.getName().equals("getLong")) return 1L;
                    return null;
                }
        );

        PreparedStatement pstmt = (PreparedStatement) Proxy.newProxyInstance(
                PreparedStatement.class.getClassLoader(),
                new Class[]{PreparedStatement.class},
                (proxy, method, args) -> {
                    if (method.getName().equals("executeUpdate")) return 1;
                    if (method.getName().equals("getGeneratedKeys")) return rs;
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
