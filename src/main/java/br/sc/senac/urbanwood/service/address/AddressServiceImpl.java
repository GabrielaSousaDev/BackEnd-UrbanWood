package br.sc.senac.urbanwood.service.address;

import br.sc.senac.urbanwood.dto.adress.AddressDTO;
import br.sc.senac.urbanwood.dto.woodwork.WoodworkDTO;
import br.sc.senac.urbanwood.exception.address.AddressNotFoundException;
import br.sc.senac.urbanwood.mapper.AddressMapper;
import br.sc.senac.urbanwood.model.Address;
import br.sc.senac.urbanwood.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

	private AddressRepository addressRepository;
	private AddressMapper addressMapper;

	public AddressServiceImpl(AddressRepository addressRepository, AddressMapper addressMapper) {
		this.addressRepository = addressRepository;
		this.addressMapper = addressMapper;
	}

	@Override
	public AddressDTO save(AddressDTO dto) {
		Address address = new Address(dto.id(),dto.streetName() , dto.number(), dto.neighborhood(),
				dto.complement(), dto.city(), dto.cep());
		Address addressSaved = addressRepository.save(address);
	    return addressMapper.toDTO(addressSaved);
	}

	@Override
	public void update(AddressDTO dto, Long id) {
		Address address = addressRepository.findById(id)
				.orElseThrow(() -> new AddressNotFoundException("Client " + id + " was not found"));

		address.setNeighborhood(dto.neighborhood());
		address.setCep(dto.cep());
		address.setCity(dto.city());
		address.setComplement(dto.complement());
		address.setNumber(dto.number());
		address.setStreetName(dto.streetName());

		addressRepository.saveAndFlush(address);
	}

	@Override
	public void delete(Long id) {
		addressRepository.findById(id)
				.orElseThrow(() -> new AddressNotFoundException("Client " + id + " was not found"));
		addressRepository.deleteById(id);
	}

	@Override
	public AddressDTO findById(Long id) {
		Address address = addressRepository.findById(id)
				.orElseThrow(() -> new AddressNotFoundException("Client " + id + " was not found"));
		return addressMapper.toDTO(address);
	}

}