package EX11.EX51Colecoes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GerenciadorTarefas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> tarefas = new ArrayList<>();
        System.out.println("Digite 5 tarefas iniciais:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Tarefa " + (i + 1) + ": ");
            tarefas.add(scanner.nextLine());
        }

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Remover tarefa");
            System.out.println("3. Buscar tarefa");
            System.out.println("4. Exibir tarefas ordenadas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção invalida, digite apenas numeros.");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome da tarefa: ");
                    String novaTarefa = scanner.nextLine();
                    tarefas.add(novaTarefa);
                    System.out.println("Tarefa adicionada");
                    break;

                case 2:
                    if (tarefas.isEmpty()) {
                        System.out.println("A lista de tarefas esta vazia.");
                        break;
                    }
                    System.out.print("Digite o nome da tarefa que deseja remover: ");
                    String tarefaRemover = scanner.nextLine();
                    if (tarefas.remove(tarefaRemover)) {
                        System.out.println("Tarefa removida");
                    } else {
                        System.out.println("Tarefa não encontrada.");
                    }
                    break;

                case 3:
                    if (tarefas.isEmpty()) {
                        System.out.println("A lista de tarefas esta vazia.");
                        break;
                    }
                    System.out.print("Digite o nome da tarefa para buscar: ");
                    String tarefaBuscar = scanner.nextLine();
                    if (tarefas.contains(tarefaBuscar)) {
                        System.out.println("A tarefa " + tarefaBuscar + " esta na lista.");
                    } else {
                        System.out.println("A tarefa " + tarefaBuscar + " não esta na lista.");
                    }
                    break;

                case 4:
                    if (tarefas.isEmpty()) {
                        System.out.println("A lista de tarefas esta vazia.");
                        break;
                    }
                    Collections.sort(tarefas);
                    System.out.println("\nLista de tarefas ordenada:");
                    for (String tarefa : tarefas) {
                        System.out.println("- " + tarefa);
                    }
                    break;

                case 0:
                    System.out.println("Encerrando.");
                    break;

                default:
                    System.out.println("Opção invalida! Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}