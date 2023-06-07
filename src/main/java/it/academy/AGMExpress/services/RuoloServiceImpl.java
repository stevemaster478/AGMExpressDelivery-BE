package it.academy.AGMExpress.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.academy.AGMExpress.entity.Ruolo;
import it.academy.AGMExpress.repositories.RuoloRepository;

@Service
public class RuoloServiceImpl implements RuoloService {
    private final RuoloRepository ruoloRepository;

    @Autowired
    public RuoloServiceImpl(RuoloRepository ruoloRepository) {
        this.ruoloRepository = ruoloRepository;
    }

    @Override
    public List<Ruolo> getAllRuoli() {
        return ruoloRepository.findAll();
    }

    @Override
    public Ruolo getRuoloById(Long id) {
        return ruoloRepository.findById(id).orElse(null);
    }

    @Override
    public Ruolo saveRuolo(Ruolo ruolo) {
        return ruoloRepository.save(ruolo);
    }

    @Override
    public void deleteRuolo(Long id) {
        ruoloRepository.deleteById(id);
    }
}
