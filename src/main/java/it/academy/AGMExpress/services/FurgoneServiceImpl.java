package it.academy.AGMExpress.services;

import it.academy.AGMExpress.entity.Furgone;
import it.academy.AGMExpress.repositories.FurgoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FurgoneServiceImpl implements FurgoneService {

    private final FurgoneRepository furgoneRepository;

    @Autowired
    public FurgoneServiceImpl(FurgoneRepository furgoneRepository) {
        this.furgoneRepository = furgoneRepository;
    }

    @Override
    public List<Furgone> getAllFurgoni() {
        Iterable<Furgone> furgoniIterable = furgoneRepository.findAll();
        List<Furgone> furgoniList = new ArrayList<>();
        furgoniIterable.forEach(furgoniList::add);
        return furgoniList;
    }


    @Override
    public Furgone getFurgoneByTarga(String targa) {
        Optional<Furgone> optionalFurgone = furgoneRepository.findById(targa);
        return optionalFurgone.orElse(null);
    }

    @Override
    public void saveFurgone(Furgone furgone) {
        furgoneRepository.save(furgone);
    }

    @Override
    public void deleteFurgone(String targa) {
        furgoneRepository.deleteById(targa);
    }
}

