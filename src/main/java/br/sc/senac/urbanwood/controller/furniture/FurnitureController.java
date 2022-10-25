package br.sc.senac.urbanwood.controller.furniture;

import br.sc.senac.urbanwood.dto.furniture.FurnitureDTO;
import br.sc.senac.urbanwood.service.furniture.FurnitureServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/furniture")
public class FurnitureController {

    private final FurnitureServiceImpl furnitureServiceImpl;

    public FurnitureController( FurnitureServiceImpl furnitureServiceImpl) {
        this.furnitureServiceImpl = furnitureServiceImpl;
    }

    @PostMapping
    public ResponseEntity<FurnitureDTO> addFurniture(@RequestBody FurnitureDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(furnitureServiceImpl.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateFurniture(@RequestBody FurnitureDTO furnitureDTO, @PathVariable(value = "id") Long id) {
        furnitureServiceImpl.update(furnitureDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body("Furniture updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFurniture(@PathVariable(value = "id") Long id) {
        furnitureServiceImpl.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Furniture deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<FurnitureDTO> getFindById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(furnitureServiceImpl.findById(id));
    }

    /* teste*/
}