package br.sc.senac.urbanwood.mapper;

import org.springframework.stereotype.Service;

import br.sc.senac.urbanwood.dto.ClientDTO;
import br.sc.senac.urbanwood.model.Client;

@Service
public class ClientMapper {

	 public ClientDTO toDTO(Client client) {
	        return new ClientDTO(client.getId(), client.getCpf(), client.getFirstName(), client.getLastName(), client.getOrder());
	    }

	    public Client toEntity(ClientDTO dto) {
	        return new Client();
	    }
}
