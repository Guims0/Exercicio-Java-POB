package EX18.EX87;

import java.util.List;
import java.util.Optional;

public interface GenericDAO<T, ID> {
    void salvar(T entidade);
    Optional<T> buscarPorId(ID id);
    List<T> listarTodos();
    void atualizar(T entidade);
    void deletarPorId(ID id);
}