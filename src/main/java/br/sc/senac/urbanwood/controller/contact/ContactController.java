package br.sc.senac.urbanwood.controller.contact;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sc.senac.urbanwood.dto.contact.ContactDTO;
import br.sc.senac.urbanwood.projection.ContactProjection;
import br.sc.senac.urbanwood.service.contact.ContactService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/contact")
public class ContactController {
	
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ResponseEntity<ContactDTO> addContact(@RequestBody ContactDTO contactDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contactService.save(contactDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateContact(@RequestBody ContactDTO contactDTO, @PathVariable(value = "id") Long id) {
        contactService.update(contactDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body("Contact updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable(value = "id") Long id) {
        contactService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Contact deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactProjection> getProjectionById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(contactService.findById(id));
    }
   
    /*@GetMapping
    public ResponseEntity<ContactDTO> getProjectionByWoodoworkPhoneNumber(@PathVariable(value = "phoneNumberWoodwork") String phoneNumberWoodwork) {
        return ResponseEntity.status(HttpStatus.OK).body(contactService.findByWoodworkPhoneNumber(phoneNumberWoodwork));
    }*/
}