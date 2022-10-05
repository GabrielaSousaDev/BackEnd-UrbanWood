package br.sc.senac.urbanwood.dto;

import br.sc.senac.urbanwood.model.User;

public record AddressDTO(Long id, String streetName, int number, String neighborhood, String complement, String city,
		String cep, User user) {

}
