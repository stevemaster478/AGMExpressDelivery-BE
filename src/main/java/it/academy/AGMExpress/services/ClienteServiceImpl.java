package it.academy.AGMExpress.services;

import it.academy.AGMExpress.entity.Cliente;
import it.academy.AGMExpress.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;


    @Override
    public List<Cliente> getAllClienti() {
        List<Cliente> clients = new ArrayList<>();





        return clients;
    }

    @Override
    public Cliente getClienteById(int id) {
        return null;
    }

    @Override
    public void saveCliente() {

    }

    @Override
    public void deleteCliente() {

    }
}
