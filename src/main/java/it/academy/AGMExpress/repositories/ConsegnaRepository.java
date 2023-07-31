package it.academy.AGMExpress.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.academy.AGMExpress.entity.Consegna;

@Repository
public interface ConsegnaRepository extends CrudRepository<Consegna, Integer> {
}

