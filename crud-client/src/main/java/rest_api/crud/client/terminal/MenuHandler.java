package rest_api.crud.client.terminal;

public class MenuHandler {
    public void printMenu() {
        System.out.println("\n ========== MENU REST CLIENT ==========");
        System.out.println("1 - Criar usuário");
        System.out.println("2 - Listar usuários");
        System.out.println("3 - Consultar usuário");
        System.out.println("4 - Atualizar usuário");
        System.out.println("5 - Deletar usuário");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }
}
