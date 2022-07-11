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
                System.out.println("Salvando Clientes.");
                Cliente cliente = new Cliente("Leo");
                clientes.salvar(cliente);

                Cliente cliente2 = new Cliente("Outro");
                clientes.salvar(cliente2);

                List<Cliente> todosClientes = clientes.obterTodos();
                todosClientes.forEach(System.out::println);

                System.out.println("Atualizando Clientes");
                todosClientes.forEach(c -> {
                    c.setNome(c.getNome() + " atualizado");
                    clientes.atualizar(c);
                });

                todosClientes = clientes.obterTodos();
                todosClientes.forEach(System.out::println);

                System.out.println("Buscando clientes");
                clientes.buscarPorNome("Ou").forEach(System.out::println);

//                System.out.println("Deletando clientes");
//                clientes.obterTodos().forEach(c -> {
//                    clientes.deletar(c);
//                });

                todosClientes = clientes.obterTodos();
                if (todosClientes.isEmpty()){
                    System.out.println("Nenhum Cliente Encontrado");
                }
                else {
                    todosClientes.forEach(System.out::println);
                }
            };
        }

        public static void main(String[] args){
            SpringApplication.run(VendasApplication.class, args);
        }
}