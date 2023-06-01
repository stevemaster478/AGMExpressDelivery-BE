package it.academy.AGMExpress.controllers;


import it.academy.AGMExpress.entity.Cliente;
import it.academy.AGMExpress.entity.Consegna;
import it.academy.AGMExpress.repositories.ClienteRepository;
import it.academy.AGMExpress.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clienti")
public class ClienteController {


    private final ClienteService clienteService;
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteController(ClienteService clienteService,
                             ClienteRepository clienteRepository) {
        this.clienteService = clienteService;
        this.clienteRepository = clienteRepository;
    }


    @GetMapping(value = {"/", ""})
    public ResponseEntity<List<Cliente>> getAllClienti() {
        List<Cliente> clientList = clienteService.getAllClienti();

        if (clientList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(clientList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable int id) {
        Cliente client = clienteService.getClienteById(id);

        if (client == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(client);
    }

    @PostMapping(value = {"/", ""})
    public ResponseEntity<Void> createCliente(@RequestBody Cliente c) {
        clienteService.saveCliente(c);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable int id, @RequestBody Cliente c) {
        return ResponseEntity.ok(clienteService.updateCliente(c).get());
    }



}
