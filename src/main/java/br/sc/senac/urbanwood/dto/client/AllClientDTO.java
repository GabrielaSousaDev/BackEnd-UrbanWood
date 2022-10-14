package br.sc.senac.urbanwood.dto.client;

public record AllClientDTO(Long idClient, String firstName, String lastName, String cpfClient, String nameStreet, 
		int number, String complement, String neighborhood, String city, String cep, String socialNetwork, 
		String email, String phone, String login, String password) {}
