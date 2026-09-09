package EX06.EX26Livros;

public class Livro {
    String titulo;
    String autor;
    int numeroPaginas;

    void exibirInformacoes() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Paginas: " + numeroPaginas);
        System.out.println("-------------------------");
    }
}
