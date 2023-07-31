package it.academy.AGMExpress.services;

import it.academy.AGMExpress.entity.Indirizzo;
import it.academy.AGMExpress.repositories.IndirizzoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class IndirizzoServiceImpl implements IndirizzoService {

    @Autowired
    IndirizzoRepository indirizzoRepository;


    @Override
    public List<Indirizzo> getAllIndirizzi() {
        List<Indirizzo> indirizzo = new ArrayList<>();

        Iterable<Indirizzo> indirizzoIterable = indirizzoRepository.findAll();

        indirizzoIterable.forEach(indirizzo::add);

        return indirizzo;
    }

    @Override
    public Indirizzo getIndirizzoById(int id) {
        Optional<Indirizzo> optionalIndirizzo = indirizzoRepository.findById(id);
        return optionalIndirizzo.orElse(null);
    }

    @Override
    public void saveIndirizzo(Indirizzo ind) {
        indirizzoRepository.save(ind);
    }

    @Override
    public void deleteIndirizzo(int id) {
        indirizzoRepository.deleteById(id);
    }

    @Override
    public Optional<Indirizzo> updateIndirizzo(Indirizzo ind) {
        return indirizzoRepository.findById(ind.getId()).map(
                cliente -> {
                    cliente.setId(ind.getId());
                    cliente.setCap(ind.getCap());
                    cliente.setCliente(ind.getCliente());
                    cliente.setVia(ind.getVia());
                    cliente.setCitta(ind.getCitta());
                    cliente.setNumeroCivico(ind.getNumeroCivico());
                    cliente.setInterno(ind.getInterno());
                    return indirizzoRepository.save(cliente);
                }
        );
    }
}
