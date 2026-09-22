package EX08.EX38PoliHeranca;

public class PushNotificacao extends Notificacao {
    public PushNotificacao(String destinatario) {
        super(destinatario);
    }

    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando Push para o dispositivo " + getDestinatario() + ": " + mensagem);
    }
}
