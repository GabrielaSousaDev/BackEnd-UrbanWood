package br.sc.senac.urbanwood.controller.address;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.sc.senac.urbanwood.dto.AddressDTO;
import br.sc.senac.urbanwood.projection.AddressProjection;
import br.sc.senac.urbanwood.projection.ProfileWoodworkForEditProjection;
import br.sc.senac.urbanwood.service.address.AddressService;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity<AddressDTO> addAddress(@RequestBody AddressDTO addressDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.save(addressDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAddress(@RequestBody AddressDTO addressDTO, @PathVariable(value = "id") Long id) {
        addressService.update(addressDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body("Address updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable(value = "id") Long id) {
        addressService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Address deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressProjection> getProjectionById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.findById(id));
    }

    @GetMapping("/{neighborhoodWoodwork}")
    public ResponseEntity<java.util.List<ProfileWoodworkForEditProjection>> getProjectionByNeighborhood(@PathVariable(value = "neighborhood") String neighborhood) {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.findByWoodworkNeighborhood(neighborhood));
    }
}