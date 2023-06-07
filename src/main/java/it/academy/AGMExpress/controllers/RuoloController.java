package it.academy.AGMExpress.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import it.academy.AGMExpress.entity.Ruolo;
import it.academy.AGMExpress.services.RuoloService;

@RestController
@RequestMapping("/ruoli")
public class RuoloController {
    private final RuoloService ruoloService;

    @Autowired
    public RuoloController(RuoloService ruoloService) {
        this.ruoloService = ruoloService;
    }

    @GetMapping
    public ResponseEntity<List<Ruolo>> getAllRuoli() {
        List<Ruolo> ruoli = ruoloService.getAllRuoli();
        if (ruoli.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ruoli);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ruolo> getRuoloById(@PathVariable Long id) {
        Ruolo ruolo = ruoloService.getRuoloById(id);
        if (ruolo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ruolo);
    }

    @PostMapping
    public ResponseEntity<Ruolo> createRuolo(@RequestBody Ruolo ruolo) {
        Ruolo savedRuolo = ruoloService.saveRuolo(ruolo);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRuolo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ruolo> updateRuolo(@PathVariable Long id, @RequestBody Ruolo ruolo) {
        Ruolo existingRuolo = ruoloService.getRuoloById(id);
        if (existingRuolo == null) {
            return ResponseEntity.notFound().build();
        }
        ruolo.setId(existingRuolo.getId()); // Assicura che l'ID sia corretto
        Ruolo updatedRuolo = ruoloService.saveRuolo(ruolo);
        return ResponseEntity.ok(updatedRuolo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRuolo(@PathVariable Long id) {
        Ruolo ruolo = ruoloService.getRuoloById(id);
        if (ruolo == null) {
            return ResponseEntity.notFound().build();
        }
        ruoloService.deleteRuolo(id);
        return ResponseEntity.noContent().build();
    }
}
