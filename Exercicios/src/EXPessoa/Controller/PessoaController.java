package EXPessoa.Controller;

import EXPessoa.Model.Pessoa;

import java.util.ArrayList;

public class PessoaController {

    private ArrayList<Pessoa> pessoas;
    private PessoaRepository pessoaRepository;

    public PessoaController() {
        this.pessoaRepository = new PessoaRepository();
        this.pessoas = pessoaRepository.carregarPessoas();
    }

    public ArrayList<Pessoa> listarPessoas() {
        return new ArrayList<>(pessoas);
    }

    public void adicionarPessoa(int id, String nome, int idade, double altura) {
        Pessoa pessoa = new Pessoa(id, nome, idade, altura);
        pessoas.add(pessoa);
        pessoaRepository.salvarPessoas(pessoas);
    }

    public boolean alterarPessoa(int id, String novoNome, int novaIdade, double novaAltura) {
        Pessoa pessoa = buscarPessoaPorId(id);
        if (pessoa != null) {
            pessoa.setNome(novoNome);
            pessoa.setIdade(novaIdade);
            pessoa.setAltura(novaAltura);
            pessoaRepository.salvarPessoas(pessoas);
            return true;
        }
        return false;
    }

    public boolean excluirPessoa(int id) {
        Pessoa pessoa = buscarPessoaPorId(id);
        if (pessoa != null) {
            pessoas.remove(pessoa);
            pessoaRepository.salvarPessoas(pessoas);
            return true;
        }
        return false;
    }

    private Pessoa buscarPessoaPorId(int id) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null;
    }
}
