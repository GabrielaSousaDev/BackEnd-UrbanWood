package br.sc.senac.urbanwood.service.woodwork;

import br.sc.senac.urbanwood.dto.client.ClientDTO;
import br.sc.senac.urbanwood.dto.woodwork.WoodworkDTO;
import br.sc.senac.urbanwood.exception.client.ClientNotFoundException;
import br.sc.senac.urbanwood.exception.woodwork.WoodworkNotFoundException;
import br.sc.senac.urbanwood.mapper.WoodworkMapper;
import br.sc.senac.urbanwood.model.*;
import br.sc.senac.urbanwood.repository.AddressRepository;
import br.sc.senac.urbanwood.repository.ContactRepository;
import br.sc.senac.urbanwood.repository.WoodworkRepository;
import org.springframework.stereotype.Service;

@Service
public class WoodworkServiceImpl implements WoodworkService {

	private final WoodworkRepository woodworkRepository;
	private final WoodworkMapper woodworkMapper;
	private final ContactRepository contactRepository;
	private final AddressRepository addressRepository;

	public WoodworkServiceImpl(WoodworkRepository woodworkRepository, WoodworkMapper woodworkMapper,
			ContactRepository contactRepository, AddressRepository addressRepository) {
		this.woodworkRepository = woodworkRepository;
		this.woodworkMapper = woodworkMapper;
		this.contactRepository = contactRepository;
		this.addressRepository = addressRepository;
	}
	public WoodworkDTO save(WoodworkDTO dto) {
		Woodwork woodwork = new Woodwork(dto.idUser(), dto.login(), dto.password(),
				dto.address(),dto.contact(),dto.image(),dto.companyName(), dto.description(), dto.cnpj(),
				dto.furniture(), dto.order(),dto.environment());
		return woodworkMapper.toDTO(woodworkRepository.save(woodwork));
	}

	public void delete(Long id) {
		if (!woodworkRepository.existsById(id))
			throw new WoodworkNotFoundException("Woodwork " + id + " was not found");
		woodworkRepository.deleteById(id);
	}

	public WoodworkDTO findById(Long id) {
		Woodwork woodwork = woodworkRepository.findById(id)
				.orElseThrow(() -> new WoodworkNotFoundException("WoodWork " + id + " was not found"));
		return woodworkMapper.toDTO(woodwork);
	}
//	public void update(WoodworkDTO/ dto, Long id) {
//
//		Client client = Repository.findById(id)
//				.orElseThrow(() -> new ClientNotFoundException("Client " + id + " was not found"));
//
//		client.setCpf(dto.cpf());
//		client.setLastName(dto.lastName());
//		client.setFirstName(dto.firstName());
//		client.setContact(dto.contact());
//		client.setAddress(dto.address());
//		client.setImage(dto.imageProfile());
//		clientRepository.saveAndFlush(client);
//	}
}