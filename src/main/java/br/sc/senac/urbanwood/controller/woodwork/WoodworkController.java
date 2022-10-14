package br.sc.senac.urbanwood.controller.woodwork;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sc.senac.urbanwood.dto.woodwork.AllWoodworkDTO;
import br.sc.senac.urbanwood.service.woodwork.WoodworkService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/woodwork")
public class WoodworkController {

    private final WoodworkService woodworkService;
    
    public WoodworkController(WoodworkService woodworkService) {
        this.woodworkService = woodworkService;
    }
	
   @PostMapping
    public ResponseEntity<AllWoodworkDTO> addWoodwork(@RequestBody AllWoodworkDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(woodworkService.save(dto));
    }

   /* @PutMapping("/{id}")
    public ResponseEntity<String> updateWoodwork(@RequestBody WoodworkDTO woodworkDTO, @PathVariable(value = "id") Long id) {
        woodworkService.update(woodworkDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body("Woodwork updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWoodwork(@PathVariable(value = "id") Long id) {
        woodworkService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Woodwork deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileWoodworkFullEditProjection> getProjectionById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkService.findById(id));
    }

    @GetMapping("/{cnpj}")
    public ResponseEntity<ProfileWoodworkForEditProjection> getProjectionByCnpj(@PathVariable(value = "cnpj") String cnpj) {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkService.findByCnpj(cnpj));
    }

    @GetMapping("/{companyName}")
    public ResponseEntity<List<ProfileWoodworkForEditProjection>> getProjectionByCompanyName(@PathVariable(value = "companyName") String companyName) {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkService.findByCompanyName(companyName));
    }

    @GetMapping("/{phoneNumberWoodwork}")
    public ResponseEntity<List<ProfileWoodworkForEditProjection>> getProjectionByPhoneNumber(@PathVariable(value = "phoneNumber") String phoneNumber) {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkService.findByPhoneNumber(phoneNumber));
    }
    
    @GetMapping("/{neighborhoodWoodwork}")
    public ResponseEntity<List<ProfileWoodworkForEditProjection>> getProjectionByNeighborhood(@PathVariable(value = "neighborhood") String neighborhood) {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkService.findByNeighborhood(neighborhood));
    }
    
    */
}