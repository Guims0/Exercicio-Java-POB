package EX16.EX78;

import java.util.Optional;

public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void atualizarEmail(Long id, String novoEmail) {
        Optional<Usuario> usuarioEncontrado = repository.buscarPorId(id);
        if (usuarioEncontrado.isPresent()) {
            Usuario usuario = usuarioEncontrado.get();
            usuario.setEmail(novoEmail);
            repository.salvar(usuario);
        }
    }
}