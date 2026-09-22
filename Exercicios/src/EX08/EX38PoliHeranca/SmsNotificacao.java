package EX08.EX38PoliHeranca;

public class SmsNotificacao extends Notificacao {
    public SmsNotificacao(String destinatario) {
        super(destinatario);
    }

    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando SMS para o número " + getDestinatario() + ": " + mensagem);
    }
}
