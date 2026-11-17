package EX17.EX82;

import EX17.EX82.Produto;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Produto> buscarPorFaixaPreco(Connection conn, double min, double max) {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT id, nome, preco, estoque FROM produtos WHERE preco BETWEEN ? AND ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, min);
            pstmt.setDouble(2, max);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Long id = rs.getLong("id");
                    String nome = rs.getString("nome");
                    Double preco = rs.getDouble("preco");
                    Integer estoque = rs.getInt("estoque");

                    Produto produto = new Produto(id, nome, preco, estoque);
                    produtos.add(produto);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar produtos: " + e.getMessage());
        }

        return produtos;
    }

    public static void main(String[] args) {
        Connection conn = criarConexaoSimulada();
        List<Produto> lista = buscarPorFaixaPreco(conn, 50.0, 200.0);

        for (Produto p : lista) {
            System.out.println(p);
        }
    }

    private static Connection criarConexaoSimulada() {
        int[] linha = {0};

        ResultSet rs = (ResultSet) Proxy.newProxyInstance(
                ResultSet.class.getClassLoader(),
                new Class[]{ResultSet.class},
                (proxy, method, args) -> {
                    String nomeMetodo = method.getName();
                    if (nomeMetodo.equals("next")) {
                        linha[0]++;
                        return linha[0] <= 2;
                    }
                    if (nomeMetodo.equals("getLong")) return (long) linha[0];
                    if (nomeMetodo.equals("getString")) return linha[0] == 1 ? "Teclado Mecanico" : "Mouse Gamer";
                    if (nomeMetodo.equals("getDouble")) return linha[0] == 1 ? 150.0 : 85.0;
                    if (nomeMetodo.equals("getInt")) return linha[0] == 1 ? 10 : 25;
                    return null;
                }
        );

        PreparedStatement pstmt = (PreparedStatement) Proxy.newProxyInstance(
                PreparedStatement.class.getClassLoader(),
                new Class[]{PreparedStatement.class},
                (proxy, method, args) -> {
                    if (method.getName().equals("executeQuery")) return rs;
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