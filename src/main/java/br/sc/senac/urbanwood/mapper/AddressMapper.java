package br.sc.senac.urbanwood.mapper;


import br.sc.senac.urbanwood.dto.adress.AddressDTO;
import br.sc.senac.urbanwood.model.Address;
import org.springframework.stereotype.Service;

@Service
public class AddressMapper {

	 public AddressDTO toDTO(Address address) {
	        return new AddressDTO(address.getId(), address.getStreetName(), address.getNumber(), address.getNeighborhood(),
	        		address.getComplement(), address.getCity(),address.getCep());
	    }

	    public Address toEntity(AddressDTO dto) {
	        return new Address(dto.id(),dto.streetName(),dto.number(),dto.neighborhood(),dto.complement(),dto.city(),
	        	dto.cep());
	    }
}
