package it.academy.AGMExpress.repositories;

import it.academy.AGMExpress.entity.Pacco;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaccoRepository extends CrudRepository<Pacco, Integer> {



    @Query(value = "SELECT p FROM Pacco p WHERE p.destinatario.id=:clienteid")
    public List<Pacco> getUserPacchi(@Param("clienteid") Integer clienteId);

}
