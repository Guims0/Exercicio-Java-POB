package EX09.EX43Abstract;

public class Main {
    public static void main(String[] args) {
        Usuario user = new Usuario("joao.silva", "12345");
        Administrador admin = new Administrador("admin.master", "senhaForte", "TOTAL");

        System.out.println("Usuário autenticado? " + user.autenticar("12345"));
        System.out.println("Admin autenticado? " + admin.autenticar("errada"));

        System.out.println("Dados do admin: " + admin.exportarJSON());
    }
}
