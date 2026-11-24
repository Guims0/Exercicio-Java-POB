package EX18.EX87;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProdutoDAOImpl implements GenericDAO<Produto, Long> {

    @Override
    public void salvar(Produto p) {
        String sql = "INSERT INTO produtos (descricao, preco_unitario, quantidade_estoque) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, p.getDescricao());
            ps.setBigDecimal(2, p.getPrecoUnitario());
            ps.setInt(3, p.getQuantidadeEstoque());
            ps.executeUpdate();

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) p.setId(keys.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar produto", e);
        }
    }

    @Override
    public Optional<Produto> buscarPorId(Long id) {
        String sql = "SELECT id, descricao, preco_unitario, quantidade_estoque FROM produtos WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? Optional.of(mapear(rs)) : Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar produto " + id, e);
        }
    }

    @Override
    public List<Produto> listarTodos() {
        String sql = "SELECT id, descricao, preco_unitario, quantidade_estoque FROM produtos ORDER BY id";
        List<Produto> lista = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) lista.add(mapear(rs));
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar produtos", e);
        }
        return lista;
    }

    @Override
    public void atualizar(Produto p) {
        String sql = "UPDATE produtos SET descricao = ?, preco_unitario = ?, quantidade_estoque = ? WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getDescricao());
            ps.setBigDecimal(2, p.getPrecoUnitario());
            ps.setInt(3, p.getQuantidadeEstoque());
            ps.setLong(4, p.getId());
            if (ps.executeUpdate() == 0) {
                throw new RuntimeException("Produto " + p.getId() + " não encontrado");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar produto", e);
        }
    }

    @Override
    public void deletarPorId(Long id) {
        String sql = "DELETE FROM produtos WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar produto " + id, e);
        }
    }

    private Produto mapear(ResultSet rs) throws SQLException {
        Produto p = new Produto();
        p.setId(rs.getLong("id"));
        p.setDescricao(rs.getString("descricao"));
        p.setPrecoUnitario(rs.getBigDecimal("preco_unitario"));
        p.setQuantidadeEstoque(rs.getInt("quantidade_estoque"));
        return p;
    }
}
