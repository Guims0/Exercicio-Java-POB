package EX18.EX86;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAOImpl implements AlunoDAO {

    private final Connection conn;

    public AlunoDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void inserir(Aluno aluno) {
        String sql = "INSERT INTO alunos (nome, matricula) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getMatricula());
            ps.executeUpdate();

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    aluno.setId(keys.getLong(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir aluno", e);
        }
    }

    @Override
    public List<Aluno> listarTodos() {
        String sql = "SELECT id, nome, matricula FROM alunos ORDER BY id";
        List<Aluno> alunos = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Aluno a = new Aluno();
                a.setId(rs.getLong("id"));
                a.setNome(rs.getString("nome"));
                a.setMatricula(rs.getString("matricula"));
                alunos.add(a);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar alunos", e);
        }
        return alunos;
    }
}