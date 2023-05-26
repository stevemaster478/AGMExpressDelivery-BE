package it.academy.AGMExpress.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.academy.AGMExpress.entity.Furgone;

@Repository
public interface FurgoneRepository extends CrudRepository<Furgone, String> {
}

