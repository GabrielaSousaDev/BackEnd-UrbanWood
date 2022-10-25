package br.sc.senac.urbanwood.controller.woodwork;

import br.sc.senac.urbanwood.dto.woodwork.WoodworkDTO;
import br.sc.senac.urbanwood.service.woodwork.WoodworkService;
import br.sc.senac.urbanwood.service.woodwork.WoodworkServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/woodwork")
public class WoodworkController {

    private final WoodworkServiceImpl woodworkServiceImpl;

    public WoodworkController(WoodworkServiceImpl woodworkServiceImpl) {
        this.woodworkServiceImpl = woodworkServiceImpl;
    }

   @PostMapping
    public ResponseEntity<WoodworkDTO> addWoodwork(@RequestBody WoodworkDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(woodworkServiceImpl.save(dto));
    }

   @DeleteMapping("/{id}")
   public ResponseEntity<String> deleteWoodwork(@PathVariable(value = "id") Long id) {
       woodworkServiceImpl.delete(id);
       return ResponseEntity.status(HttpStatus.OK).body("Woodwork deleted successfully");
   }
    @GetMapping("/{id}")
    public ResponseEntity<WoodworkDTO> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkServiceImpl.findById(id));
    }

}