package br.sc.senac.urbanwood.controller;

import org.springframework.stereotype.Controller;

import br.sc.senac.urbanwood.repository.AdressRepository;

@Controller
public abstract class AdressController implements AdressRepository {
	
	@PostMapping("/Adress")
    public ResponseEntity<Student> save(@RequestBody @Valid Student student) {
        return new ResponseEntity<>(studentRepository.save(student), HttpStatus.CREATED);
    }

}
