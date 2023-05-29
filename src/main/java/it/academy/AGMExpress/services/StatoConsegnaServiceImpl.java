package it.academy.AGMExpress.services;

import it.academy.AGMExpress.entity.StatoConsegna;
import it.academy.AGMExpress.repositories.StatoConsegnaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StatoConsegnaServiceImpl implements StatoConsegnaService {
    private final StatoConsegnaRepository statoConsegnaRepository;

    public StatoConsegnaServiceImpl(StatoConsegnaRepository statoConsegnaRepository) {
        this.statoConsegnaRepository = statoConsegnaRepository;
    }

    @Override
    public List<StatoConsegna> getAllStatiConsegne() {
        Iterable<StatoConsegna> statiConsegneIterable = statoConsegnaRepository.findAll();
        List<StatoConsegna> statiConsegneList = new ArrayList<>();
        statiConsegneIterable.forEach(statiConsegneList::add);
        return statiConsegneList;
    }

    @Override
    public StatoConsegna getStatoConsegnaById(int id) {
        Optional<StatoConsegna> optionalStatoConsegna =statoConsegnaRepository.findById(id);
        return optionalStatoConsegna.orElse(null);
    }

    @Override
    public void saveStatoConsegna(StatoConsegna statoConsegna) {
        statoConsegnaRepository.save(statoConsegna);
    }

    @Override
    public void deleteStatoConsegna(int id) {
        statoConsegnaRepository.deleteById(id);
    }
}
