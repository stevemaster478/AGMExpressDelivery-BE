package it.academy.AGMExpress.services;

import it.academy.AGMExpress.entity.Cliente;
import it.academy.AGMExpress.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;


    @Override
    public List<Cliente> getAllClienti() {
        List<Cliente> clients = new ArrayList<>();
        Iterable<Cliente> consegneIterable = clienteRepository.findAll();
        consegneIterable.forEach(clients::add);
        return clients;

    }

    @Override
    public Cliente getClienteById(int id) {
        Optional<Cliente> optionalConsegna = clienteRepository.findById(id);
        return optionalConsegna.orElse(null);
    }

    @Override
    public void saveCliente(Cliente c) {
        clienteRepository.save(c);
    }

    @Override
    public void deleteCliente(int id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public Optional<Cliente> updateCliente(Cliente c) {

        return clienteRepository.findById(c.getId()).map(
                cliente -> {
                    cliente.setNome(c.getNome());
                    cliente.setCognome(c.getCognome());
                    cliente.setPacchiInviati(c.getPacchiInviati());
                    cliente.setPacchiRicevuti(c.getPacchiRicevuti());
                    cliente.setNumeroTelefono(c.getNumeroTelefono());
                    cliente.setPartitaIva(c.getPartitaIva());
                    return clienteRepository.save(cliente);
                }
        );
    }
}



