package br.sc.senac.urbanwood.service.client;


import br.sc.senac.urbanwood.dto.client.ClientDTO;
import br.sc.senac.urbanwood.exception.client.ClientNotFoundException;
import br.sc.senac.urbanwood.mapper.AddressMapper;
import br.sc.senac.urbanwood.mapper.ClientMapper;
import br.sc.senac.urbanwood.mapper.ContactMapper;
import br.sc.senac.urbanwood.model.Client;
import br.sc.senac.urbanwood.repository.ClientRepository;
import br.sc.senac.urbanwood.service.address.AddressServiceImpl;
import br.sc.senac.urbanwood.service.contact.ContactServiceImpl;
import org.springframework.stereotype.Service;
import br.sc.senac.urbanwood.service.encryptor.Encryptor;


@Service
public class ClientServiceImpl implements ClientService {

	private final ClientRepository clientRepository;
	private final ClientMapper clientMapper;
	private final ContactServiceImpl contactServiceImpl;
	private final AddressServiceImpl addressServiceImpl;
	private final ContactMapper contactMapper;
	private final AddressMapper addressMapper;

	public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper, ContactServiceImpl contactServiceImpl, AddressServiceImpl addressServiceImpl, ContactMapper contactMapper, AddressMapper addressMapper) {
		this.clientRepository = clientRepository;
		this.clientMapper = clientMapper;
		this.contactServiceImpl = contactServiceImpl;
		this.addressServiceImpl = addressServiceImpl;
		this.contactMapper = contactMapper;
		this.addressMapper = addressMapper;
	}


	public ClientDTO save(Client dto) {
		Client clientSaved = clientRepository.save(dto);
		return clientMapper.toDTO(clientSaved);
	}

	public void update(ClientDTO dto, Long id) {

		Client client = clientRepository.findById(id)
				.orElseThrow(() -> new ClientNotFoundException("Client " + id + " was not found"));

		client.setCpf(dto.cpf());
		client.setLastName(dto.lastName());
		client.setFirstName(dto.firstName());
		client.setContact(dto.contact());
		client.setAddress(dto.address());
		client.setImage(dto.imageProfile());
		clientRepository.saveAndFlush(client);
	}
	public void delete(Long id) {

		if (!clientRepository.existsById(id))
			throw new ClientNotFoundException("Client " + id + " was not found");

		clientRepository.deleteById(id);
	}

	public ClientDTO findById(Long id) {
		Client client = clientRepository.findById(id)
				.orElseThrow(() -> new ClientNotFoundException("Client " + id + " was not found"));
		return clientMapper.toDTO(client);
	}
}
