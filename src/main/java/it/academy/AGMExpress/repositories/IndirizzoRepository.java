package it.academy.AGMExpress.repositories;


import it.academy.AGMExpress.entity.Indirizzo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndirizzoRepository extends CrudRepository<Indirizzo, Integer> {
}
