package EX10.EX50TryCatch;

public class Main {
    public static void main(String[] args) {
        ServicoProcessamento servico = new ServicoProcessamento();

        try {
            servico.processarArquivo("");
        } catch (ProcessamentoDadosException e) {
            System.out.println("Mensagem de erro : " + e.getMessage());

            if (e.getCause() != null) {
                System.out.println("Causa raiz do problema: " + e.getCause().getMessage());
            }
        }
    }
}
