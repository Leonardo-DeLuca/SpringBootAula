package Application;

import Application.domain.entity.Cliente;
import Application.domain.repository.Clientes;
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
                clientes.save(cliente);

                Cliente cliente2 = new Cliente("Outro");
                clientes.save(cliente2);

                List<Cliente> result= clientes.encontrarPorNome("Leo");
                result.forEach(System.out::println);



/*                List<Cliente> todosClientes = clientes.findAll();
                todosClientes.forEach(System.out::println);

              System.out.println("Atualizando Clientes");
                todosClientes.forEach(c -> {
                    c.setNome(c.getNome() + " atualizado");
                    clientes.save(c);
                });

                todosClientes = clientes.findAll();
                todosClientes.forEach(System.out::println);

                System.out.println("Buscando clientes");
                clientes.findByNomeLike("Ou").forEach(System.out::println);

                System.out.println("Deletando clientes");
                clientes.findAll().forEach(c -> {
                    clientes.delete(c);
                });

                todosClientes = clientes.findAll();
                if (todosClientes.isEmpty()){
                    System.out.println("Nenhum Cliente Encontrado");
                }
                else {
                    todosClientes.forEach(System.out::println);
                }
                */
            };
        }

        public static void main(String[] args){
            SpringApplication.run(VendasApplication.class, args);
        }
}