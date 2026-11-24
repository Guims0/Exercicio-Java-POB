package EX18.EX88;

import java.util.List;

public interface LivroDAO {
    void salvar(Livro livro);
    List<Livro> buscarPaginado(int pagina, int tamanhoPagina);
}
