package EX16.EX79;

public class NotificacaoService {
    private final EmailSender emailSender;

    public NotificacaoService(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void notificarBoasVindas(Usuario usuario) {
        String primeiroNome = usuario.getNome().split(" ")[0];
        String assunto = "Bem-vindo ao sistema";
        String corpo = "Ola " + primeiroNome + ", sua conta foi criada com sucesso.";
        emailSender.enviar(usuario.getEmail(), assunto, corpo);
    }
}