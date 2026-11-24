package EX18.EX88;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LivroDAOImpl implements LivroDAO {

    @Override
    public void salvar(Livro livro) {
        String sql = "INSERT INTO livros (titulo, autor) VALUES (?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, livro.getTitulo());
            ps.setString(2, livro.getAutor());
            ps.executeUpdate();

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) livro.setId(keys.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar livro", e);
        }
    }

    @Override
    public List<Livro> buscarPaginado(int pagina, int tamanhoPagina) {
        if (pagina < 1) {
            throw new IllegalArgumentException("pagina deve ser >= 1");
        }
        if (tamanhoPagina < 1) {
            throw new IllegalArgumentException("tamanhoPagina deve ser >= 1");
        }

        int limit = tamanhoPagina;
        long offset = (long) (pagina - 1) * tamanhoPagina;

        String sql = "SELECT id, titulo, autor FROM livros ORDER BY id LIMIT ? OFFSET ?";
        List<Livro> livros = new ArrayList<>(tamanhoPagina);

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, limit);
            ps.setLong(2, offset);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Livro l = new Livro();
                    l.setId(rs.getLong("id"));
                    l.setTitulo(rs.getString("titulo"));
                    l.setAutor(rs.getString("autor"));
                    livros.add(l);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar livros paginados", e);
        }
        return livros;
    }
}
