package br.sc.senac.urbanwood.mapper;

import org.springframework.stereotype.Service;

import br.sc.senac.urbanwood.dto.AddressDTO;
import br.sc.senac.urbanwood.model.Address;

@Service
public class AddressMapper {

	/*
	 public AddressDTO toDTO(Address address) {
	        return new AddressDTO(address.getId(), address.getStreetName(), address.getNumber(), address.getNeighborhood(),
	        		address.getComplement(), address.getCity(),address.getCep(), address.getUser());
	    }

	    public Address toEntity(AddressDTO dto) {
	        return new Address(dto.id(),dto.streetName(),dto.number(),dto.neighborhood(),dto.complement(),dto.city(),
	        	dto.cep(),dto.user());
	    }*/
}
