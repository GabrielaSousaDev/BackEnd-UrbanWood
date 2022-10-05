package br.sc.senac.urbanwood.dto;

import br.sc.senac.urbanwood.model.Address;
import br.sc.senac.urbanwood.model.Contact;
import br.sc.senac.urbanwood.model.Image;

public record UserDTO(Long id,  Image image, String login, String password, Address address, Contact contact) {

	

}
