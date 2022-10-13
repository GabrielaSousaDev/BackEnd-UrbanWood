package br.sc.senac.urbanwood.dto.client;

public record AllClientDTO(Long idClient, String nameClient, String lastName, String cpfClient, String nameStreet, 
		int number, String complement, String neighborhood, String city, String cep, String socialNetwork, 
		String email, String phone) {}
