package it.academy.AGMExpress.services;

import it.academy.AGMExpress.entity.Cliente;
import it.academy.AGMExpress.entity.Indirizzo;

import java.util.List;
import java.util.Optional;

public interface IndirizzoService {


    List<Indirizzo> getAllIndirizzi();
    Indirizzo getIndirizzoById(int id);

    void saveIndirizzo(Indirizzo ind);

    void deleteIndirizzo(int id);

    Optional<Indirizzo> updateIndirizzo(Indirizzo ind);
}
