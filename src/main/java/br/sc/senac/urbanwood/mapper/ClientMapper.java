package br.sc.senac.urbanwood.mapper;

import org.springframework.stereotype.Service;

import br.sc.senac.urbanwood.dto.ClientDTO;
import br.sc.senac.urbanwood.dto.client.AllClientDTO;
import br.sc.senac.urbanwood.model.Address;
import br.sc.senac.urbanwood.model.Client;
import br.sc.senac.urbanwood.model.Contact;

@Service
public class ClientMapper {

	 public AllClientDTO toAllDTO(Client client) {
	        return new AllClientDTO(client.getId(), client.getFirstName(),client.getLastName(),client.getCpf(),client.getAddress().getStreetName(), client.getAddress().getNumber(), 
	    			client.getAddress().getNeighborhood(), client.getAddress().getComplement(), client.getAddress().getCity(), client.getAddress().getCep(), client.getContact().getEmail(), 
	    			client.getContact().getNetWork(), client.getContact().getPhoneNumber(),client.getLogin(),client.getPassword());
	    }

	    /*public Client toAllEntity(AllClientDTO dto) {
	    	Contact contact = new Contact(dto.idClient(), dto.email(), dto.phone(), dto.socialNetwork());
	    	Address address = new Address(dto.idClient(), dto.nameStreet(), dto.number(), dto.neighborhood(), dto.complement(), dto.city(), dto.cep());
	        return new Client(dto.idClient(), null, dto.login(), dto.password(), address, contact, dto.cpfClient(), dto.firstName(), dto.lastName());
	    }*/
}
