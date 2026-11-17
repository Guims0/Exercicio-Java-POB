package EX17.EX84;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void inserirLoteLog(Connection conn, List<String> mensagensLog) {
        String sql = "INSERT INTO logs_sistema (mensagem, data_registro) VALUES (?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (String mensagem : mensagensLog) {
                pstmt.setString(1, mensagem);
                pstmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
                pstmt.addBatch();
            }

            int[] resultados = pstmt.executeBatch();
            System.out.println("Lote executado com sucesso! Total de logs inseridos: " + resultados.length);
        } catch (SQLException e) {
            System.out.println("Erro ao inserir lote de logs: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Connection conn = criarConexaoSimulada();
        List<String> logs = Arrays.asList(
                "Sistema iniciado",
                "Usuario autenticado",
                "Requisicao processada"
        );

        inserirLoteLog(conn, logs);
    }

    private static Connection criarConexaoSimulada() {
        int[] quantidadeBatch = {0};

        PreparedStatement pstmt = (PreparedStatement) Proxy.newProxyInstance(
                PreparedStatement.class.getClassLoader(),
                new Class[]{PreparedStatement.class},
                (proxy, method, args) -> {
                    if (method.getName().equals("addBatch")) {
                        quantidadeBatch[0]++;
                    }
                    if (method.getName().equals("executeBatch")) {
                        int[] retorno = new int[quantidadeBatch[0]];
                        Arrays.fill(retorno, 1);
                        return retorno;
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