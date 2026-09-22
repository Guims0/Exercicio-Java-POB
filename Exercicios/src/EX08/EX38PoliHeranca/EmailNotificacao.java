package EX08.EX38PoliHeranca;

public class EmailNotificacao extends Notificacao {
    public EmailNotificacao(String destinatario) {
        super(destinatario);
    }

    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando E-mail para " + getDestinatario() + ": " + mensagem);
    }
}
