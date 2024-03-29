package it.academy.AGMExpress.controllers;

import it.academy.AGMExpress.entity.Pacco;
import it.academy.AGMExpress.repositories.PaccoRepository;
import it.academy.AGMExpress.services.PaccoService;
import it.academy.AGMExpress.utilities.TrackingCodeGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/pacchi")
public class PaccoController {

    @Autowired
    private PaccoService paccoService;
    private final PaccoRepository paccoRepository;

    @Autowired
    public PaccoController(PaccoService paccoService,
                           PaccoRepository paccoRepository) {
        this.paccoService = paccoService;
        this.paccoRepository = paccoRepository;
    }

    @GetMapping
    public ResponseEntity<List<Pacco>> getAllPacchi() {
        List<Pacco> pacchi = paccoService.getAllPacchi();
        if (pacchi.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pacchi);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Pacco> getPaccoById(@PathVariable int id) {
        Pacco pacco = paccoService.getPaccoById(id);

<<<<<<< HEAD
=======
    @GetMapping("/{id}")
    public ResponseEntity<Pacco> getPaccoById(@PathVariable int id) {
        Pacco pacco = paccoService.getPaccoById(id);

>>>>>>> 40eea8bab731d0e357873d8d65fb4220e725d823
        if (pacco == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pacco);
    }
<<<<<<< HEAD
    
    @PostMapping("/utentePacchi")
    public ResponseEntity<List<Pacco>> getUserPacchi(@RequestBody Integer idUser){

        List<Pacco> pacchi = paccoRepository.getUserPacchi(idUser);
        if (pacchi.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pacchi);
    }
=======
>>>>>>> 40eea8bab731d0e357873d8d65fb4220e725d823

    @PostMapping
    public ResponseEntity<Void> createPacco(@RequestBody Pacco pacco) {
        if (pacco.getTrackingCode() == null || pacco.getTrackingCode().isEmpty()) {
            // Genera un nuovo tracking code utilizzando il tuo generatore di tracking code
            String trackingCode = TrackingCodeGenerator.generateTrackingCode();
            pacco.setTrackingCode(trackingCode);
        } else {
            // Verifica che il tracking code inserito rispetti il formato desiderato
            String regex = "^[A-Za-z0-9]{10}$";
            if (!pacco.getTrackingCode().matches(regex)) {
                // Ritorna una risposta HTTP 400 - Bad Request se il tracking code non è valido
                return ResponseEntity.badRequest().build();
            }
        }

        paccoService.savePacco(pacco);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePacco(@PathVariable int id, @RequestBody Pacco pacco) {
        Pacco existingPacco = paccoService.getPaccoById(id);

        if (existingPacco == null) {
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePacco(@PathVariable int id) {
        Pacco existingPacco = paccoService.getPaccoById(id);
        if (existingPacco == null) {
            return ResponseEntity.notFound().build();
        }
        paccoService.deletePacco(id);
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
