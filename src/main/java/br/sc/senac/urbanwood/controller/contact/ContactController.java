package br.sc.senac.urbanwood.controller.contact;

import br.sc.senac.urbanwood.dto.contact.ContactDTO;
import br.sc.senac.urbanwood.service.contact.ContactServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/contact")
public class ContactController  {
    private final ContactServiceImpl contactServiceImpl;

    public ContactController(ContactServiceImpl contactServiceImpl) {
        this.contactServiceImpl = contactServiceImpl;
    }

    @PostMapping
    public ResponseEntity<ContactDTO> saveContact(@RequestBody @Validated ContactDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contactServiceImpl.save(dto));
    }
//    @GetMapping("/{id}")
//    public ResponseEntity<ContactDTO> getContactById(@PathVariable(value = "id") Long id) {
//        return ResponseEntity.status(HttpStatus.OK).body(contactServiceImpl.findById(id));
//    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable(value = "id") Long id) {
        contactServiceImpl.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Client deleted successfully");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateContact(@RequestBody ContactDTO dto, @PathVariable(value = "id") Long id) {
        contactServiceImpl.update(dto, id);
        return ResponseEntity.status(HttpStatus.OK).body("Client updated successfully");
    }
}