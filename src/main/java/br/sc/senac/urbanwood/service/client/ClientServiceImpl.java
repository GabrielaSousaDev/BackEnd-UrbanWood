package br.sc.senac.urbanwood.service.client;

import java.util.List;

import org.springframework.stereotype.Service;

import br.sc.senac.urbanwood.dto.client.AllClientDTO;
import br.sc.senac.urbanwood.exception.address.AddressNotFoundException;
import br.sc.senac.urbanwood.exception.client.ClientCpfRegisteredException;
import br.sc.senac.urbanwood.exception.client.ClientNotFoundException;
import br.sc.senac.urbanwood.exception.contact.ContactEmailRegisteredException;
import br.sc.senac.urbanwood.exception.contact.ContactNotFoundException;
import br.sc.senac.urbanwood.exception.contact.ContactPhoneNumberRegisteredException;
import br.sc.senac.urbanwood.mapper.ClientMapper;
import br.sc.senac.urbanwood.model.Address;
import br.sc.senac.urbanwood.model.Client;
import br.sc.senac.urbanwood.model.Contact;
import br.sc.senac.urbanwood.projection.client.ClientProjection;
import br.sc.senac.urbanwood.repository.AddressRepository;
import br.sc.senac.urbanwood.repository.ClientRepository;
import br.sc.senac.urbanwood.repository.ContactRepository;

@Service
public class ClientServiceImpl implements ClientService {

	private final ClientRepository clientRepository;
	private final ClientMapper clientMapper;
	private final ContactRepository contactRepository;
	private final AddressRepository addressRepository;

	public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper,
			ContactRepository contactRepository, AddressRepository addressRepository) {
		this.clientRepository = clientRepository;
		this.clientMapper = clientMapper;
		this.contactRepository = contactRepository;
		this.addressRepository = addressRepository;

	}

	public AllClientDTO save(AllClientDTO dto) {

    	Contact contact = new Contact(dto.idClient(), dto.email(), dto.phone(), dto.socialNetwork());
    	Contact contactSaved = contactRepository.save(contact);
    	
    	Address address = new Address(dto.idClient(), dto.nameStreet(), dto.number(), dto.neighborhood(), dto.complement(), dto.city(), dto.cep());
    	Address addressSaved = addressRepository.save(address);
    	
    	Client client = new Client(dto.idClient(), null, dto.login(), dto.password(), address, contact, dto.cpfClient(), dto.firstName(), dto.lastName());
    	Client clientSaved = clientRepository.save(client);
    	
    	
		return clientMapper.toAllDTO(clientSaved);
	}
	
	public void update(AllClientDTO dto, Long id) {
		
		Client client = clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException("Client " + id + " was not found"));
		Contact contact = contactRepository.findById(id).orElseThrow(() -> new ContactNotFoundException("Contact " + id + " was not found"));
		Address address = addressRepository.findById(id).orElseThrow(() -> new AddressNotFoundException("Client " + id + " was not found"));
		
		if(clientRepository.existsByCpf(dto.cpfClient()))
			throw new ClientCpfRegisteredException("Cpf "+ dto.cpfClient() +" already registered.");
			
		if(contactRepository.existsByEmail(dto.email()))
			throw new ContactEmailRegisteredException("Email "+ dto.email() +" already registered.");
		
		if(contactRepository.existsByPhoneNumber(dto.phone()))
			throw new ContactPhoneNumberRegisteredException("Phone "+ dto.phone() +" already registered.");
		
		if(addressRepository.existsByCep(dto.cep()))
			throw new AddressNotFoundException(null);
			
		client.setCpf(dto.cpfClient()); 
		client.setLastName(dto.lastName());
		client.setFirstName(dto.firstName());
		contact.setEmail(dto.email());
		contact.setPhoneNumber(dto.phone());
		contact.setNetWork(dto.socialNetwork());
		
		clientRepository.save(client);
	}
	
	public void delete(Long id) {

		if (!clientRepository.existsById(id)) 
			throw new ClientNotFoundException("Client " + id + " was not found");
		
		 clientRepository.deleteById(id);
	}
	
	public AllClientDTO findById(Long id) { 
		Client client = clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException("Client " + id + " was not found")); 
		return clientMapper.toAllDTO(client);
	}
	
	public List<ClientProjection> findAll() {
		return clientRepository.findClients();
	}
	/*
	 * public void update(ClientDTO clientDTO, Long id) {
	 * 
	 * Client client = clientRepository.findById(id) .orElseThrow(() -> new
	 * ClientNotFoundException("Client " + id + " was not found"));
	 * 
	 * if (CPFValidator.isCPF(clientDTO.cpf())) throw new
	 * ClientCpfInvalidException("Cpf " + clientDTO.cpf() + " is invalid");
	 * 
	 * if (clientDTO.cpf().equals(client.getCpf()) &&
	 * clientDTO.login().equals(client.getLogin())) {
	 * client.setCpf(clientDTO.cpf()); client.setLogin(clientDTO.login());
	 * client.setImage(clientDTO.image()); client.setPassword(clientDTO.password());
	 * client.setLastName(clientDTO.lastName());
	 * client.setFirstName(clientDTO.firstName()); clientRepository.save(client);
	 * return; }
	 * 
	 * if (clientRepository.existsByCpf(clientDTO.cpf())) throw new
	 * ClientCpfRegisteredException("Cpf " + clientDTO.cpf() +
	 * " is already registered");
	 * 
	 * if (clientRepository.existsByLogin(clientDTO.login())) throw new
	 * ClientLoginRegisteredException("Login " + clientDTO.login() +
	 * " is already registered");
	 * 
	 * client.setCpf(clientDTO.cpf()); client.setLogin(clientDTO.login());
	 * client.setImage(clientDTO.image()); client.setPassword(clientDTO.password());
	 * client.setLastName(clientDTO.lastName());
	 * client.setNameClient(clientDTO.nameClient()); clientRepository.save(client);
	 * }
	 * 
	 * public void delete(Long id) { if (!clientRepository.existsById(id)) throw new
	 * ClientNotFoundException("Client " + id + " was not found");
	 * clientRepository.deleteById(id); }
	 * 
	 * public ClientProjection findById(Long id) { return
	 * clientRepository.findClientById(id) .orElseThrow(() -> new
	 * ClientNotFoundException("Client " + id + " was not found")); }
	 * 
	 * public ClientProjection findByCpf(String cpf) { return
	 * clientRepository.findClientByCpf(cpf) .orElseThrow(() -> new
	 * ClientNotFoundException("Client " + cpf + " was not found")); }
	 * 
	 * public List<ClientProjection> findByNameClient(String nameClient) {
	 * List<ClientProjection> client =
	 * clientRepository.findClientByNameClient(nameClient);
	 * 
	 * if (client.isEmpty()) throw new ClientNotFoundException("Client " +
	 * nameClient + " was not found"); return client; }
	 * 
	 * //Screen
	 * 
	 * public Page<ClientProjectionW9> findW9ByNameClient(Pageable pageable, Integer
	 * page) { pageable = PageRequest.of(page, 3, Sort.Direction.ASC, "nameClient");
	 * return clientRepository.findClientW9ByNameClient(pageable); }
	 * 
	 * public ClientProjectionW10 findW10ById(Long id) { return
	 * clientRepository.findClientW10ById(id) .orElseThrow(() -> new
	 * ClientNotFoundException("Client " + id + " was not found")); }
	 * 
	 * public ClientProjectionC13 findC13ById(Long id) { return
	 * clientRepository.findClientC13ById(id) .orElseThrow(() -> new
	 * ClientNotFoundException("Client " + id + " was not found")); }
	 * 
	 * public ClientProjectionC6 findC6ById(Long id) { return
	 * clientRepository.findClientC6ById(id) .orElseThrow(() -> new
	 * ClientNotFoundException("Client " + id + " was not found")); }
	 * 
	 * public ClientProjectionC7 findC7ById(Long id) { return
	 * clientRepository.findClientC7ById(id) .orElseThrow(() -> new
	 * ClientNotFoundException("Client " + id + " was not found")); }
	 */

}