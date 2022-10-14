package br.sc.senac.urbanwood.dto.woodwork;

public record AllWoodworkDTO(Long idWoodwork, String companyName, String cnpj, String description, String nameStreet, 
		int number, String complement, String neighborhood, String city, String cep, String socialNetwork, 
		String email, String phone, String login, String password) {

}
