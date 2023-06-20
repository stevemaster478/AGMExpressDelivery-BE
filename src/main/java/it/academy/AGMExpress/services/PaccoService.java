package it.academy.AGMExpress.services;

import it.academy.AGMExpress.entity.Pacco;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaccoService {
    public List<Pacco> getAllPacchi();
    public Pacco getPaccoById(int id);
    public void savePacco(Pacco pacco);
    public void deletePacco(int id);

}
