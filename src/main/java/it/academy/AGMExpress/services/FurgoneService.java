package it.academy.AGMExpress.services;

import it.academy.AGMExpress.entity.Furgone;
import java.util.List;

public interface FurgoneService {
    public List<Furgone> getAllFurgoni();
    public Furgone getFurgoneByTarga(String targa);
    public void saveFurgone(Furgone furgone);
    public void deleteFurgone(String targa);
}

