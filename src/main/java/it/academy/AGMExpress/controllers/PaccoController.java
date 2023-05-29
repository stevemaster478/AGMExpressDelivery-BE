package it.academy.AGMExpress.controllers;

import it.academy.AGMExpress.entity.Pacco;
import it.academy.AGMExpress.services.PaccoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/pacchi")
public class PaccoController {
    private final PaccoService paccoService;
    @Autowired
    public PaccoController(PaccoService paccoService) {
        this.paccoService = paccoService;
    }
    @GetMapping
    public ResponseEntity<List<Pacco>> getAllPacchi(){
        List<Pacco> pacchi = paccoService.getAllPacchi();
        if (pacchi.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pacchi);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Pacco> getPaccoById(@PathVariable int id) {
        Pacco pacco =paccoService.getPaccoById(id);

        if (pacco == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pacco);
    }
    @PostMapping
    ResponseEntity<Void> createPacco(@RequestBody Pacco pacco) {
        paccoService.savePacco(pacco);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePacco(@PathVariable int id, @RequestBody Pacco pacco) {
        Pacco existingPacco = paccoService.getPaccoById(id);

        if(existingPacco == null) {
            return ResponseEntity.notFound().build();
        }
        existingPacco.setId_mittente(pacco.getId_mittente());
        existingPacco.setId_destinatario(pacco.getId_destinatario());
        existingPacco.setPeso(pacco.getPeso());
        existingPacco.setProfondita(pacco.getProfondita());
        existingPacco.setLarghezza(pacco.getLarghezza());
        existingPacco.setAltezza(pacco.getAltezza());
        existingPacco.setTipo(pacco.getTipo());
        existingPacco.setStato(pacco.getStato());
        existingPacco.setTrackingCode(pacco.getTrackingCode());

        paccoService.savePacco(existingPacco);

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
