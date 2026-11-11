package EXPessoa;

import EXPessoa.Controller.PessoaController;
import EXPessoa.View.PessoaView;

public class Main{
    public static void main(String[] args) {
        PessoaController controller = new PessoaController();
        PessoaView view = new PessoaView(controller);
        view.exibirMenu();
    }
}
