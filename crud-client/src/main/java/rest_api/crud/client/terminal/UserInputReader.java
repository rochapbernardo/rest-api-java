package rest_api.crud.client.terminal;

import rest_api.crud.client.model.User;

import java.util.Scanner;

public class UserInputReader {
    private final Scanner scanner = new Scanner(System.in);

    public long readId() {
        System.out.print("ID: ");
        return Long.parseLong(scanner.nextLine());
    }

    public User readUserData() {
        User user = new User();

        System.out.print("Name: ");
        String nome = scanner.nextLine();
        if (!nome.isBlank()) user.setNome(nome);

        System.out.print("E-mail: ");
        String email = scanner.nextLine();
        if (!email.isBlank()) user.setEmail(email);

        System.out.print("Date of birth: ");
        String dt = scanner.nextLine();
        if (!dt.isBlank()) user.setDt_nascimento(dt);

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        if (!cpf.isBlank()) user.setCpf(cpf);

        return user;
    }
}
