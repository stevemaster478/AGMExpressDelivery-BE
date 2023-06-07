package it.academy.AGMExpress.controllers;

import it.academy.AGMExpress.entity.StatoConsegna;
import it.academy.AGMExpress.services.StatoConsegnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/stato_consegna")
public class StatoConsegnaController {
    private final StatoConsegnaService statoConsegnaService;
    @Autowired
    public StatoConsegnaController(StatoConsegnaService statoConsegnaService) {
        this.statoConsegnaService = statoConsegnaService;
    }
    @GetMapping
    public ResponseEntity<List<StatoConsegna>> getAllStatiConsegne(){
        List<StatoConsegna> statiConsegne =statoConsegnaService.getAllStatiConsegne();
        if (statiConsegne.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(statiConsegne);
    }
    @PostMapping
    ResponseEntity<Void> createStatoConsegna(@RequestBody StatoConsegna statoConsegna) {
        statoConsegnaService.saveStatoConsegna(statoConsegna);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateStatoConsegna(@PathVariable int id, @RequestBody StatoConsegna statoConsegna) {
        StatoConsegna existingStatoConsegna = statoConsegnaService.getStatoConsegnaById(id);

        if(existingStatoConsegna == null){
            return ResponseEntity.notFound().build();
        }
        existingStatoConsegna.setAvanzamento(statoConsegna.getAvanzamento());
        existingStatoConsegna.setStatoConsegna(statoConsegna.getStatoConsegna());

        statoConsegnaService.saveStatoConsegna(existingStatoConsegna);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatoConsegna(@PathVariable int id) {
        StatoConsegna statoConsegna = statoConsegnaService.getStatoConsegnaById(id);

        if (statoConsegna == null) {
            return ResponseEntity.notFound().build();
        }

        statoConsegnaService.deleteStatoConsegna(id);

        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Elemento non trovato!");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore interno del server");
    }
}
