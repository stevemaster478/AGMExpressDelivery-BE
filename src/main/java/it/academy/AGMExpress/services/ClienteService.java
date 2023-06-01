package it.academy.AGMExpress.services;

import it.academy.AGMExpress.entity.Cliente;
import it.academy.AGMExpress.entity.Indirizzo;

import java.util.List;
import java.util.Optional;

public interface ClienteService {


    List<Cliente> getAllClienti();
    Cliente getClienteById(int id);

    void saveCliente(Cliente c);

    void deleteCliente(int id);

    Optional<Cliente> updateCliente(Cliente c);
}
