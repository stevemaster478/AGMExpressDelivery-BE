package it.academy.AGMExpress.repositories;

import it.academy.AGMExpress.entity.Pacco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaccoRepository extends CrudRepository<Pacco, Integer> {
}
