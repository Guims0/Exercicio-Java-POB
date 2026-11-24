package EX18.EX89;

import java.util.Optional;

public interface ClienteDAO {
    void salvar(Cliente cliente);
    Optional<Cliente> buscarPorCpf(String cpf);
}