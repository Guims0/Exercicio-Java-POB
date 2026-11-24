package EX18.EX89;

public class ClienteService {

    private final ClienteDAO clienteDAO;

    public ClienteService(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public void cadastrarCliente(Cliente cliente) {
        if (cliente == null) {
            throw new RegraDeNegocioException("Cliente não pode ser nulo");
        }
        if (cliente.getEmail() == null || cliente.getEmail().isBlank()) {
            throw new RegraDeNegocioException("E-mail é obrigatório");
        }
        if (cliente.getCpf() == null || cliente.getCpf().isBlank()) {
            throw new RegraDeNegocioException("CPF é obrigatório");
        }
        if (clienteDAO.buscarPorCpf(cliente.getCpf()).isPresent()) {
            throw new RegraDeNegocioException("Já existe cliente cadastrado com o CPF " + cliente.getCpf());
        }

        clienteDAO.salvar(cliente);
    }
}