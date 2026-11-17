package EX17.EX83;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

    public static void atualizarSalario(Connection conn, Long id, double novoSalario) {
        String sql = "UPDATE funcionarios SET salario = ? WHERE id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, novoSalario);
            pstmt.setLong(2, id);

            int linhasAfetadas = pstmt.executeUpdate();

            if (linhasAfetadas == 0) {
                System.out.println("Nenhum registro encontrado com o ID informado.");
            } else {
                System.out.println("Salario atualizado com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar salario: " + e.getMessage());
        }
    }

    public static void deletarPorId(Connection conn, Long id) {
        String sql = "DELETE FROM funcionarios WHERE id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);

            int linhasAfetadas = pstmt.executeUpdate();

            if (linhasAfetadas == 0) {
                System.out.println("Nenhum registro encontrado com o ID informado.");
            } else {
                System.out.println("Funcionario deletado com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar funcionario: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Connection conn = criarConexaoSimulada();

        atualizarSalario(conn, 1L, 3500.0);
        atualizarSalario(conn, 99L, 3500.0);

        deletarPorId(conn, 1L);
        deletarPorId(conn, 99L);
    }

    private static Connection criarConexaoSimulada() {
        long[] ultimoId = {0L};

        PreparedStatement pstmt = (PreparedStatement) Proxy.newProxyInstance(
                PreparedStatement.class.getClassLoader(),
                new Class[]{PreparedStatement.class},
                (proxy, method, args) -> {
                    if (method.getName().equals("setLong")) {
                        ultimoId[0] = (Long) args[1];
                    }
                    if (method.getName().equals("executeUpdate")) {
                        return ultimoId[0] == 1L ? 1 : 0;
                    }
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