package br.sc.senac.urbanwood.dto;

import br.sc.senac.urbanwood.model.Address;
import br.sc.senac.urbanwood.model.Contact;
import br.sc.senac.urbanwood.model.Image;

public record UserDTO(Long id, String login, String password, Contact contact, Address address, Image imagem) {

}
