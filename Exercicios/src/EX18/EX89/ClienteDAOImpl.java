package EX18.EX89;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class ClienteDAOImpl implements ClienteDAO {

    @Override
    public void salvar(Cliente cliente) {
        String sql = "INSERT INTO clientes (nome, cpf, email) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getEmail());
            ps.executeUpdate();

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) cliente.setId(keys.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar cliente", e);
        }
    }

    @Override
    public Optional<Cliente> buscarPorCpf(String cpf) {
        String sql = "SELECT id, nome, cpf, email FROM clientes WHERE cpf = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cpf);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return Optional.empty();

                Cliente c = new Cliente(rs.getString("nome"), rs.getString("cpf"), rs.getString("email"));
                c.setId(rs.getLong("id"));
                return Optional.of(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar cliente por CPF", e);
        }
    }
}
