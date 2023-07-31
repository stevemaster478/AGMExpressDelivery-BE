package it.academy.AGMExpress.services;


import it.academy.AGMExpress.entity.StatoConsegna;

import java.util.List;

public interface StatoConsegnaService {
    public List<StatoConsegna> getAllStatiConsegne();
    public StatoConsegna getStatoConsegnaById(int id);
    public void saveStatoConsegna (StatoConsegna statoConsegna);
    public void deleteStatoConsegna (int id);
}
