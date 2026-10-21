package EXTutorial11.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import EXTutorial11.dominio.Produto;

public class CatalogoService {
    private final List<Produto> produtos = new ArrayList<>();

    public void cadastrar(Produto p) {
        if (p == null) {
            throw new IllegalArgumentException("Não é permitido cadastrar referências nulas.");
        }
        if (produtos.contains(p)) {
            throw new IllegalStateException("Já existe um produto cadastrado com o código: " + p.getCodigo());
        }
        produtos.add(p);
    }

    public Produto obterPorPosicao(int indice) {
        if (indice < 0 || indice >= produtos.size()) {
            throw new IndexOutOfBoundsException("Posição solicitada fora do intervalo: " + indice);
        }
        return produtos.get(indice);
    }

    public boolean excluirPorCodigo(String codigo) {
        if (codigo == null) {
            return false;
        }
        return produtos.removeIf(p -> p.getCodigo().equals(codigo.trim()));
    }

    public void ordenarPorPreco() {
        Collections.sort(produtos);
    }

    public List<Produto> listarTodos() {
        return new ArrayList<>(produtos);
    }

    public int getTotalProdutos() {
        return produtos.size();
    }
}