package it.academy.AGMExpress.services;

import it.academy.AGMExpress.entity.Pacco;
import it.academy.AGMExpress.repositories.PaccoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PaccoServiceImpl implements PaccoService {
    private final PaccoRepository paccoRepository;
    @Autowired
    public PaccoServiceImpl(PaccoRepository paccoRepository) {
        this.paccoRepository = paccoRepository;
    }

    @Override
    public List<Pacco> getAllPacchi() {
        Iterable<Pacco> pacchiIterable = paccoRepository.findAll();
        List<Pacco> pacchiList = new ArrayList<>();
        pacchiIterable.forEach(pacchiList::add);
        return pacchiList;
    }

    @Override
    public Pacco getPaccoById(int id) {
        Optional<Pacco> optionalPacco = paccoRepository.findById(id);
        return optionalPacco.orElse(null);
    }

    @Override
    public void savePacco(Pacco pacco) {
        paccoRepository.save(pacco);
    }

    @Override
    public void deletePacco(int id) {
        paccoRepository.deleteById(id);
    }
}
