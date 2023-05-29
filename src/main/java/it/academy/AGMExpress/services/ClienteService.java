package it.academy.AGMExpress.services;

import it.academy.AGMExpress.entity.Cliente;

import java.util.List;

public interface ClienteService {


    List<Cliente> getAllClienti();
    Cliente getClienteById(int id);
    void saveCliente();
    void deleteCliente();
}
