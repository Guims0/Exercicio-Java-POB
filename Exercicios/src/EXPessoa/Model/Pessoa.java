package EXPessoa.Model;

public class Pessoa {
    private int id;
    private String nome;
    private int idade;
    private double altura;

    public Pessoa(int id, String nome, int idade, double altura) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String toFileString() {
        return id + ";" + nome + ";" + idade + ";" + altura;
    }

    public static Pessoa fromFileString(String line) {
        String[] data = line.split(";");

        if (data.length != 4) {
            throw new IllegalArgumentException("Linha de dados inválida para criação de Pessoa: " + line);
        }

        try {
            int id = Integer.parseInt(data[0]);
            String nome = data[1];
            int idade = Integer.parseInt(data[2]);
            double altura = Double.parseDouble(data[3]);

            return new Pessoa(id, nome, idade, altura);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Formato numérico inválido em: " + line, e);
        }
    }
}
