package EX06.EX26Livros;

public class Main {
    public static void main(String[] args) {
        Livro livro1 = new Livro();
        livro1.titulo = "Clean Code";
        livro1.autor = "Robert C. Martin";
        livro1.numeroPaginas = 425;

        Livro livro2 = new Livro();
        livro2.titulo = "O Programador Pragmático";
        livro2.autor = "Andrew Hunt e David Thomas";
        livro2.numeroPaginas = 352;

        System.out.println("Livros cadastrados");
        livro1.exibirInformacoes();
        livro2.exibirInformacoes();
    }
}
