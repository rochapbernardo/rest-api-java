package rest_api.crud.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import rest_api.crud.client.terminal.UserClientCLI;

@SpringBootApplication
public class Application {

    private final UserClientCLI cli;

    public Application(UserClientCLI cli) {
        this.cli = cli;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner runCLI() {
        return args -> cli.start();
    }

}
