package EX08.EX38PoliHeranca;

public class Main {
    public static void processarEnvio(Notificacao notificacao, String texto) {
        notificacao.enviar(texto);
    }

    public static void main(String[] args) {
        Notificacao email = new EmailNotificacao("joao@email.com");
        Notificacao sms = new SmsNotificacao("11999999999");
        Notificacao push = new PushNotificacao("iPhone do João");

        processarEnvio(email, "Bem-vindo ao sistema!");
        processarEnvio(sms, "Seu código é 1234");
        processarEnvio(push, "Você tem uma nova mensagem");
    }
}
