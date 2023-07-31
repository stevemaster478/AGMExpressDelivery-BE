package it.academy.AGMExpress.controllers;


import it.academy.AGMExpress.entity.Indirizzo;
import it.academy.AGMExpress.services.IndirizzoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/indirizzi")
public class IndirizzoController {


    @Autowired
    private IndirizzoService indirizzoService;

    @GetMapping(value = {"/", ""})
    public ResponseEntity<List<Indirizzo>> getAllIndirizzi() {
        List<Indirizzo> indirizziList = indirizzoService.getAllIndirizzi();

        if (indirizziList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(indirizziList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Indirizzo> getIndirizzoById(@PathVariable int id) {
        Indirizzo indirizzo = indirizzoService.getIndirizzoById(id);

        if (indirizzo == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(indirizzo);
    }

    @PostMapping(value = {"/", ""})
    public ResponseEntity<Void> createIndirizzo(@RequestBody Indirizzo i) {
        indirizzoService.saveIndirizzo(i);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Indirizzo> updateIndirizzo(@PathVariable int id, @RequestBody Indirizzo i) {
        return ResponseEntity.ok(indirizzoService.updateIndirizzo(i).get());
    }


}
