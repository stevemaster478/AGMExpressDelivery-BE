package it.academy.AGMExpress.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import it.academy.AGMExpress.entity.Consegna;
import it.academy.AGMExpress.services.ConsegnaService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/consegne")
public class ConsegnaController {

    private final ConsegnaService consegnaService;

    @Autowired
    public ConsegnaController(ConsegnaService consegnaService) {
        this.consegnaService = consegnaService;
    }

    @GetMapping
    public ResponseEntity<List<Consegna>> getAllConsegne() {
        List<Consegna> consegne = consegnaService.getAllConsegne();

        if (consegne.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(consegne);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consegna> getConsegnaById(@PathVariable int id) {
        Consegna consegna = consegnaService.getConsegnaById(id);

        if (consegna == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(consegna);
    }

    @PostMapping
    public ResponseEntity<Void> createConsegna(@RequestBody Consegna consegna) {
        consegnaService.saveConsegna(consegna);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateConsegna(@PathVariable int id, @RequestBody Consegna consegna) {
        Consegna existingConsegna = consegnaService.getConsegnaById(id);

        if (existingConsegna == null) {
            return ResponseEntity.notFound().build();
        }

        existingConsegna.setInizioConsegnaData(consegna.getInizioConsegnaData());
        existingConsegna.setFineConsegnaData(consegna.getFineConsegnaData());
        existingConsegna.setTarga(consegna.getTarga());

        consegnaService.saveConsegna(existingConsegna);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsegna(@PathVariable int id) {
        Consegna consegna = consegnaService.getConsegnaById(id);

        if (consegna == null) {
            return ResponseEntity.notFound().build();
        }

        consegnaService.deleteConsegna(id);

        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Elemento non trovato");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore interno del server");
    }
}

