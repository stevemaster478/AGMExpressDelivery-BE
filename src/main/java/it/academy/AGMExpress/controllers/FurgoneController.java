package it.academy.AGMExpress.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import it.academy.AGMExpress.entity.Furgone;
import it.academy.AGMExpress.services.FurgoneService;
import it.academy.AGMExpress.utilities.TargaGenerator;

@RestController
@RequestMapping("/furgoni")
public class FurgoneController {

    @Autowired
    private FurgoneService furgoneService;

    // Operazione GET per ottenere tutti i furgoni
    @GetMapping
    public ResponseEntity<List<Furgone>> getAllFurgoni() {
        List<Furgone> furgoni = furgoneService.getAllFurgoni();

        if (furgoni.isEmpty()) {
            // Ritorna una risposta HTTP 204 - No Content se non ci sono furgoni presenti
            return ResponseEntity.noContent().build();
        }

        // Ritorna una risposta HTTP 200 - OK con la lista dei furgoni
        return ResponseEntity.ok(furgoni);
    }

    // Operazione GET per ottenere un furgone per targa
    @GetMapping("/{targa}")
    public ResponseEntity<Furgone> getFurgoneByTarga(@PathVariable String targa) {
        Furgone furgone = furgoneService.getFurgoneByTarga(targa);

        if (furgone == null) {
            // Ritorna una risposta HTTP 404 - Not Found se il furgone non esiste
            return ResponseEntity.notFound().build();
        }

        // Ritorna una risposta HTTP 200 - OK con il furgone trovato
        return ResponseEntity.ok(furgone);
    }

    // Operazione POST per creare un nuovo furgone
    @PostMapping
    public ResponseEntity<Void> createFurgone(@RequestBody Furgone furgone) {
        if (furgone.getTarga() == null || furgone.getTarga().isEmpty()) {
            // Genera una nuova targa utilizzando il tuo generatore di targa
            String targaItaliana = TargaGenerator.generateTargaItaliana();
            furgone.setTarga(targaItaliana);
        } else {
            // Verifica che la targa inserita rispetti il formato italiano | Metodo regex
            if (!furgone.getTarga().matches("^[A-Z]{2}\\d{3}[A-Z]{2}$")) {
                // Ritorna una risposta HTTP 400 - Bad Request se la targa non è valida
                return ResponseEntity.badRequest().build();
            }
        }

        furgoneService.saveFurgone(furgone);

        // Ritorna una risposta HTTP 201 - Created
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // Operazione PUT per aggiornare un furgone esistente
    @PutMapping("/{targa}")
    public ResponseEntity<Void> updateFurgone(@PathVariable String targa, @RequestBody Furgone furgone) {
        Furgone existingFurgone = furgoneService.getFurgoneByTarga(targa);

        if (existingFurgone == null) {
            // Ritorna una risposta HTTP 404 - Not Found se il furgone non esiste
            return ResponseEntity.notFound().build();
        }

        // Aggiorna i dati del furgone esistente
        existingFurgone.setModello(furgone.getModello());
        existingFurgone.setCapacita(furgone.getCapacita());

        furgoneService.saveFurgone(existingFurgone);

        // Ritorna una risposta HTTP 204 - No Content
        return ResponseEntity.noContent().build();
    }

    // Operazione DELETE per eliminare un furgone
    @DeleteMapping("/{targa}")
    public ResponseEntity<Void> deleteFurgone(@PathVariable String targa) {
        Furgone furgone = furgoneService.getFurgoneByTarga(targa);

        if (furgone == null) {
            // Ritorna una risposta HTTP 404 - Not Found se il furgone non esiste
            return ResponseEntity.notFound().build();
        }

        furgoneService.deleteFurgone(targa);

        // Ritorna una risposta HTTP 204 - No Content
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
        // Gestisci l'eccezione di tipo NoSuchElementException
        // Ritorna una risposta HTTP 404 - Not Found con un messaggio di errore personalizzato
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Elemento non trovato");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        // Gestisci tutte le altre eccezioni generiche
        // Ritorna una risposta HTTP 500 - Internal Server Error con un messaggio di errore generico
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore interno del server");
    }
}
