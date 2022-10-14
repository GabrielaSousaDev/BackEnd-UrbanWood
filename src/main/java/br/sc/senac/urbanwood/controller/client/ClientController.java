package br.sc.senac.urbanwood.controller.client;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sc.senac.urbanwood.dto.client.AllClientDTO;
import br.sc.senac.urbanwood.projection.client.ClientProjection;
import br.sc.senac.urbanwood.service.client.ClientService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<AllClientDTO> addClient(@RequestBody AllClientDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(dto));
    }
/*
    @PutMapping("/{id}")
    public ResponseEntity<String> updateClient(@RequestBody ClientDTO clientDTO, @PathVariable(value = "id") Long id) {
        clientService.update(clientDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body("Client updated successfully");
    }
    
    */

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable(value = "id") Long id) {
        clientService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Client deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<AllClientDTO> getClientById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findById(id));
    }
    
    @GetMapping()
    public ResponseEntity<List<ClientProjection>> getClients() {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findAll());
    }
/*
    @GetMapping("cpf/{cpf}")
    public ResponseEntity<ClientProjection> getProjectionByCpf(@PathVariable(value = "cpf") String cpf) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findByCpf(cpf));
    }

    @GetMapping("name/{nameClient}")
    public ResponseEntity<List<ClientProjection>> getProjectionByName(@PathVariable(value = "nameClient") String nameClient) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findByNameClient(nameClient));
    }

                |||
      Screen    |||
      Screen    |||
      Screen    vvv
     

    //Approved
    @GetMapping("w9/{page}")
    public ResponseEntity<Page<ClientProjectionW9>> getProjectionW9ByName(@PathVariable(value = "page") Integer page, Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findW9ByNameClient(pageable, page));
    }

    //Approved
    @GetMapping("w10/{id}")
    public ResponseEntity<ClientProjectionW10> getProjectionW10ById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findW10ById(id));
    }


    //Error
    @GetMapping("c13/{id}")
    public ResponseEntity<ClientProjectionC13> getProjectionC13ById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findC13ById(id));
    }

    //Approved
    @GetMapping("c6/{id}")
    public ResponseEntity<ClientProjectionC6> getProjectionC6ById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findC6ById(id));
    }

    //Approved
    @GetMapping("c7/{id}")
    public ResponseEntity<ClientProjectionC7> getProjectionC7ById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findC7ById(id));
    }*/
}