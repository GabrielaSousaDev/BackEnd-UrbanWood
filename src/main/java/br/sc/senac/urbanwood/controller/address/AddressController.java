package br.sc.senac.urbanwood.controller.address;

import br.sc.senac.urbanwood.dto.adress.AddressDTO;
import br.sc.senac.urbanwood.service.address.AddressServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/address")
public class AddressController  {
    private final AddressServiceImpl addressServiceImpl;

    public AddressController(AddressServiceImpl addressServiceImpl) {
        super();
        this.addressServiceImpl = addressServiceImpl;
    }
    @PostMapping
    public ResponseEntity<AddressDTO> saveAddress(@RequestBody @Validated AddressDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(addressServiceImpl.save(dto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(addressServiceImpl.findById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable(value = "id") Long id) {
        addressServiceImpl.delete(id);
       return ResponseEntity.status(HttpStatus.OK).body("Client deleted successfully");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateClient(@RequestBody AddressDTO dto, @PathVariable(value = "id") Long id) {
       addressServiceImpl.update(dto, id);
        return ResponseEntity.status(HttpStatus.OK).body("Client updated successfully");
    }
}