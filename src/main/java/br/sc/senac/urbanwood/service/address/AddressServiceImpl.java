package br.sc.senac.urbanwood.service.address;

import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

/*
	private final AddressRepository addressRepository;
	private final AddressMapper addressMapper;

	public AddressServiceImpl(AddressRepository addressRepository, AddressMapper addressMapper) {
		this.addressRepository = addressRepository;
		this.addressMapper = addressMapper;
	}

	public AddressDTO save(AddressDTO addressDTO) {

		if (addressRepository.existsByStreetAndNumber(addressDTO.streetName(), addressDTO.number()))
			throw new AddressStreetAndNumberRegisteredException("Street " + addressDTO.streetName() + " and Number "
					+ addressDTO.number() + " are already registered");

		if (addressDTO.number() <= 0)
			throw new AddressInvalidException("Number " + addressDTO.number() + " is invalid");

		Address address = addressMapper.toEntity(addressDTO);
		Address addressSaved = addressRepository.save(address);
		return addressMapper.toDTO(addressSaved);
	}

	public void update(AddressDTO addressDTO, Long id) {

		Address address = addressRepository.findById(id)
				.orElseThrow(() -> new AddressNotFoundException("Address " + id + " was not found"));

		if (addressDTO.number() <= 0)
			throw new AddressInvalidException("Number " + addressDTO.number() + " is invalid");
	}

	public void delete(Long id) {
		if (!addressRepository.existsById(id))
			throw new AddressNotFoundException("Address " + id + " was not found");
		addressRepository.deleteById(id);
	}

	public AddressProjection findById(Long id) {
		return addressRepository.findAddressById(id)
				.orElseThrow(() -> new AddressNotFoundException("Address " + id + " was not found"));
	}

	public List findByNeighborhoodWoodwork(String neighborhoodWoodwork) {
		List<ProfileWoodworkForEditProjection> address = addressRepository.findByWoodworkNeighborhood(neighborhoodWoodwork);

		if (address.isEmpty())
			throw new WoodworkNotFoundException("Woodwork " + neighborhoodWoodwork + " was not found");
		return address;
	}

	*/

}