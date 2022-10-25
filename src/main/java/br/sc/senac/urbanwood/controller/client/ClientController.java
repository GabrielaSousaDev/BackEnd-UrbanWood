package br.sc.senac.urbanwood.controller.client;

import br.sc.senac.urbanwood.dto.client.ClientDTO;
import br.sc.senac.urbanwood.model.Client;
import br.sc.senac.urbanwood.service.client.ClientServiceImpl;
import br.sc.senac.urbanwood.service.encryptor.Encryptor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/client")
public class ClientController {

    private final ClientServiceImpl clientServiceImpl;

    public ClientController(ClientServiceImpl clientService) {
        this.clientServiceImpl = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientDTO> addClient(@RequestBody Client client) {
        client.setPassword(Encryptor.encryptor(client.getPassword()));
        return ResponseEntity.status(HttpStatus.CREATED).body(clientServiceImpl.save(client));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable(value = "id") Long id) {
        clientServiceImpl.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Client deleted successfully");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateClient(@RequestBody ClientDTO dto, @PathVariable(value = "id") Long id) {
        clientServiceImpl.update(dto, id);
        return ResponseEntity.status(HttpStatus.OK).body("Client updated successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body( clientServiceImpl.findById(id));
    }

}