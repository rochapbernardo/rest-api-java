package rest_api.crud.client.terminal;

import org.springframework.stereotype.Component;
import rest_api.crud.client.model.User;
import rest_api.crud.client.rest.UserRestClient;

import java.util.Scanner;

@Component
public class UserClientCLI {
    public void start() {
        UserRestClient rest = new UserRestClient();
        UserInputReader input = new UserInputReader();
        MenuHandler menu = new MenuHandler();

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            menu.printMenu();
            opcao = Integer.parseInt(scanner.nextLine());

            try {
                switch (opcao) {
                    case 1 -> {
                        User novo = input.readUserData();
                        User criado = rest.createUser(novo);
                        System.out.println("Criado: " + criado);
                    }
                    case 2 -> {
                        System.out.println(rest.getAllUsers());
                    }
                    case 3 -> {
                        long id = input.readId();
                        User u = rest.getUser(id);
                        System.out.println("Usuário: " + u);
                    }
                    case 4 -> {
                        long id = input.readId();
                        User dados = input.readUserData();
                        User atualizado = rest.updateUser(id, dados);
                        System.out.println("Atualizado: " + atualizado);
                    }
                    case 5 -> {
                        long id = input.readId();
                        rest.deleteUser(id);
                        System.out.println("Usuário deletado!");
                    }
                }
            } catch (Exception e) {
                System.err.println("Erro: " + e.getMessage());
            }

        } while (opcao != 0);
    }
}
