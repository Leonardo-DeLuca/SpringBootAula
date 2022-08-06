package Application;

import Application.domain.entity.Cliente;
import Application.domain.entity.Pedido;
import Application.domain.repository.Clientes;
import Application.domain.repository.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class VendasApplication {

        @Bean
        public CommandLineRunner init(
                @Autowired Clientes clientes,
                @Autowired Pedidos pedidos

        ){
            return args -> {
                System.out.println("Salvando Clientes.");
                Cliente leo = new Cliente("Leo");
                clientes.save(leo);

                Pedido p = new Pedido();
                p.setCliente(leo);
                p.setDataPedido(LocalDate.now());
                p.setTotal(BigDecimal.valueOf(100));

                pedidos.save(p);

/*                Cliente cliente = clientes.findClienteFetchPedidos(leo.getId());
                System.out.println(cliente);
                System.out.println(cliente.getPedidos());*/

                pedidos.findByCliente(leo).forEach(System.out::println);



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