package br.sc.senac.urbanwood.controller.environment;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/livingArea")
public class EnvironmentController {
/*
    private final EnvironmentService livingAreaService;

    public LivingAreaController(EnvironmentService livingAreaService) {
        this.livingAreaService = livingAreaService;
    }

    @PostMapping
    public ResponseEntity<LivingAreaDTO> addLivingArea(@RequestBody LivingAreaDTO livingAreaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(livingAreaService.save(livingAreaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateLivingArea(@RequestBody LivingAreaDTO livingAreaDTO, @PathVariable(value = "id") Long id) {
        livingAreaService.update(livingAreaDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body("Living Area updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLivingArea(@PathVariable(value = "id") Long id) {
        livingAreaService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Living Area deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivingAreaProjection> getProjectionById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(livingAreaService.findById(id));
    }

    @GetMapping("name/{nameLivingArea}")
    public ResponseEntity<List<LivingAreaProjection>> getProjectionByName(@PathVariable(value = "nameLivingArea") String nameLivingArea) {
        return ResponseEntity.status(HttpStatus.OK).body(livingAreaService.findByNameLivingArea(nameLivingArea));
    }

    /*          |||
      Screen    |||
      Screen    |||
      Screen    vvv
     

    //Approved
    @GetMapping("c16")
    public ResponseEntity<List<LivingAreaProjectionC16>> getProjectionC16OrderByName() {
        return ResponseEntity.status(HttpStatus.OK).body(livingAreaService.findC16OrderByName());
    }
    */
}
