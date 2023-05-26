package it.academy.AGMExpress.services;

import it.academy.AGMExpress.entity.Consegna;

import java.util.List;

public interface ConsegnaService {
    List<Consegna> getAllConsegne();
    Consegna getConsegnaById(int id);
    void saveConsegna(Consegna consegna);
    void deleteConsegna(int id);
}
