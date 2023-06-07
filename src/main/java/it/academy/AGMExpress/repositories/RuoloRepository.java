package it.academy.AGMExpress.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.academy.AGMExpress.entity.Ruolo;

@Repository
public interface RuoloRepository extends JpaRepository<Ruolo, Long> {
    // Puoi aggiungere qui metodi personalizzati se necessario
}
