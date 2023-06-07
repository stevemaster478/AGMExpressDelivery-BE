package it.academy.AGMExpress.services;

import java.util.List;

import it.academy.AGMExpress.entity.Ruolo;

public interface RuoloService {
    List<Ruolo> getAllRuoli();

    Ruolo getRuoloById(Long id);

    Ruolo saveRuolo(Ruolo ruolo);

    void deleteRuolo(Long id);
}
