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

    private RuoloService ruoloService;

    @Autowired
    ClienteRepository clienteRepository;
    


    @Override
    public List<Cliente> getAllClienti() {
        List<Cliente> clients = new ArrayList<>();
        Iterable<Cliente> consegneIterable = clienteRepository.findAll();
        consegneIterable.forEach(cliente -> {
            cliente.setRuolo(ruoloService.getRuoloById(cliente.getRuolo().getId()));
            clients.add(cliente);
        });
        return clients;

    }

    @Override
    public Cliente getClienteById(int id) {
        Optional<Cliente> optionalConsegna = clienteRepository.findById(id);
        if (optionalConsegna.isPresent()) {
            Cliente cliente = optionalConsegna.get();
            cliente.setRuolo(ruoloService.getRuoloById(cliente.getRuolo().getId()));
            return cliente;
        }
        return null;
    }

    @Override
    public void saveCliente(Cliente c) {
        clienteRepository.save(c);
    }

    @Override
    public boolean deleteCliente(int id) {
        try {
            clienteRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
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
                    cliente.setRuolo(c.getRuolo());
                    return clienteRepository.save(cliente);
                }
        );
    }
}



