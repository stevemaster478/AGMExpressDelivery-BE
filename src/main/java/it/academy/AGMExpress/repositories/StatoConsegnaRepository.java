package it.academy.AGMExpress.repositories;

import it.academy.AGMExpress.entity.StatoConsegna;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatoConsegnaRepository extends CrudRepository<StatoConsegna, Integer> {
}
