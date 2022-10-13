package br.sc.senac.urbanwood.controller.user;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/user")
public class UserController {

	/*
	private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@RequestBody UserDTO userDTO, @PathVariable(value = "id") Long id) {
    	userService.update(userDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body("User updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(value = "id") Long id) {
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserProjection>> getProjectionById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));
    }*/
}
