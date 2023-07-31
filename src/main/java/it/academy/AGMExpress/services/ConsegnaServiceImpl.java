package it.academy.AGMExpress.services;

import it.academy.AGMExpress.entity.Consegna;
import it.academy.AGMExpress.repositories.ConsegnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConsegnaServiceImpl implements ConsegnaService {

    private final ConsegnaRepository consegnaRepository;

    @Autowired
    public ConsegnaServiceImpl(ConsegnaRepository consegnaRepository) {
        this.consegnaRepository = consegnaRepository;
    }

    @Override
    public List<Consegna> getAllConsegne() {
        Iterable<Consegna> consegneIterable = consegnaRepository.findAll();
        List<Consegna> consegneList = new ArrayList<>();
        consegneIterable.forEach(consegneList::add);
        return consegneList;
    }


    @Override
    public Consegna getConsegnaById(int id) {
        Optional<Consegna> optionalConsegna = consegnaRepository.findById(id);
        return optionalConsegna.orElse(null);
    }

    @Override
    public void saveConsegna(Consegna consegna) {
        consegnaRepository.save(consegna);
    }

    @Override
    public void deleteConsegna(int id) {
        consegnaRepository.deleteById(id);
    }
}
