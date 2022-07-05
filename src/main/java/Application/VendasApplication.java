package Application;

import Application.domain.entity.Cliente;
import Application.domain.repositorio.Clientes;
import org.h2.command.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

        @Bean
        public CommandLineRunner init(@Autowired Clientes clientes){
            return args -> {
                Cliente cliente = new Cliente("Leo");
                clientes.salvar(cliente);

                Cliente cliente2 = new Cliente("Outro");
                clientes.salvar(cliente2);

                List<Cliente> todosClientes = clientes.obterTodos();
                todosClientes.forEach(System.out::println);
            };
        }

        public static void main(String[] args){
            SpringApplication.run(VendasApplication.class, args);
        }
}