package EX18.EX86;

public class Aluno {
    private Long id;
    private String nome;
    private String matricula;

    public Aluno() {}

    public Aluno(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    @Override
    public String toString() {
        return "Aluno{id=" + id + ", nome='" + nome + "', matricula='" + matricula + "'}";
    }
}