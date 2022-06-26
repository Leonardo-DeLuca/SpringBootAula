package Application.service;

import Application.model.Cliente;
import Application.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientesService {
    private ClientesRepository repository;

    @Autowired
    public ClientesService(ClientesRepository repository){
        this.repository = repository;
    }

    /*
    OU
    private ClientesRepository repository;

    @Autowired
    public void setRepository(ClientesRepository repository) {
        this.repository = repository;
    }*/

    /*
    OU
    @Autowired
    private ClientesRepository repository;
    * */

    public void salvarCliente(Cliente cliente){
        validarCliente(cliente);
        this.repository.persistir(cliente);
    }

    public void validarCliente(Cliente cliente){
        //aplica validações
    }
}


