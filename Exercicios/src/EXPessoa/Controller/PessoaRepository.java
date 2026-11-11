package EXPessoa.Controller;

import EXPessoa.Model.Pessoa;

import java.io.*;
import java.util.ArrayList;

public class PessoaRepository {

    private final String arquivoPessoas = "pessoas.csv";

    public void salvarPessoas(ArrayList<Pessoa> pessoas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoPessoas))) {
            for (Pessoa pessoa : pessoas) {
                writer.write(pessoa.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar pessoas: " + e.getMessage());
        }
    }

    public ArrayList<Pessoa> carregarPessoas() {
        ArrayList<Pessoa> pessoas = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoPessoas))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (!linha.trim().isEmpty()) {
                    pessoas.add(Pessoa.fromFileString(linha));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de pessoas não encontrado. Será criado ao salvar novas pessoas.");
        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Erro ao carregar pessoas: " + e.getMessage());
        }

        return pessoas;
    }
}
