package br.sc.senac.urbanwood.controller.furniture;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sc.senac.urbanwood.dto.furniture.AllFurnitureDTO;
import br.sc.senac.urbanwood.service.furniture.FurnitureService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/furniture")
public class FurnitureController {

    private final FurnitureService furnitureService;

    public FurnitureController(FurnitureService furnitureService) {
        this.furnitureService = furnitureService;
    }

    @PostMapping
    public ResponseEntity<AllFurnitureDTO> addFurniture(@RequestBody AllFurnitureDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(furnitureService.save(dto));
    }

 /*   @PutMapping("/{id}")
    public ResponseEntity<String> updateFurniture(@RequestBody FurnitureDTO furnitureDTO, @PathVariable(value = "id") Long id) {
        furnitureService.update(furnitureDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body("Furniture updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFurniture(@PathVariable(value = "id") Long id) {
        furnitureService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Furniture deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<FurnitureProjection> getProjectionById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(furnitureService.findById(id));
    }

    @GetMapping("name/{nameFurniture}")
    public ResponseEntity<List<FurnitureProjection>> getProjectionByName(@PathVariable(value = "nameFurniture") String nameFurniture) {
        return ResponseEntity.status(HttpStatus.OK).body(furnitureService.findByNameFurniture(nameFurniture));
    }

    @GetMapping("price/{priceFurniture}")
    public ResponseEntity<List<FurnitureProjection>> getProjectionByPrice(@PathVariable(value = "priceFurniture") Double priceFurniture) {
        return ResponseEntity.status(HttpStatus.OK).body(furnitureService.findByPriceFurniture(priceFurniture));
    }

    /*          |||
      Screen    |||
      Screen    |||
      Screen    vvv
     

    //Approved
    @GetMapping("c14/{id}")
    public ResponseEntity<FurnitureProjectionC14> getProjectionC14ById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(furnitureService.findC14ById(id));
    }

    //Approved
    @GetMapping("c15")
    public ResponseEntity<List<FurnitureProjectionC15>> getProjectionC15OrderByName() {
        return ResponseEntity.status(HttpStatus.OK).body(furnitureService.findC15OrderByNameFurniture());
    }
    */
}