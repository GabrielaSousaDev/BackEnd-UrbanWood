package br.sc.senac.urbanwood.service.woodwork;

import java.util.List;

import org.springframework.stereotype.Service;

import br.sc.senac.urbanwood.dto.WoodworkDTO;
import br.sc.senac.urbanwood.dto.woodwork.AllWoodworkDTO;
import br.sc.senac.urbanwood.exception.woodwork.WoodworkNotFoundException;
import br.sc.senac.urbanwood.mapper.WoodworkMapper;
import br.sc.senac.urbanwood.model.Address;
import br.sc.senac.urbanwood.model.Contact;
import br.sc.senac.urbanwood.model.Woodwork;
import br.sc.senac.urbanwood.projection.woodwork.WoodworkProjection;
import br.sc.senac.urbanwood.repository.AddressRepository;
import br.sc.senac.urbanwood.repository.ContactRepository;
import br.sc.senac.urbanwood.repository.UserRepository;
import br.sc.senac.urbanwood.repository.WoodworkRepository;

@Service
public class WoodworkServiceImpl implements WoodworkService {

	private final WoodworkRepository woodworkRepository;
	private final WoodworkMapper woodworkMapper;
	private final ContactRepository contactRepository;
	private final AddressRepository addressRepository;
	private final UserRepository userRepository;

	public WoodworkServiceImpl(WoodworkRepository woodworkRepository, WoodworkMapper woodworkMapper,
			ContactRepository contactRepository, AddressRepository addressRepository, UserRepository userRepository) {
		this.woodworkRepository = woodworkRepository;
		this.woodworkMapper = woodworkMapper;
		this.contactRepository = contactRepository;
		this.addressRepository = addressRepository;
		this.userRepository = userRepository;
	}

	public AllWoodworkDTO save(AllWoodworkDTO dto) {

		Contact contact = new Contact(dto.idWoodwork(), dto.email(), dto.phone(), dto.socialNetwork());
		Contact contactSaved = contactRepository.save(contact);

		Address address = new Address(dto.idWoodwork(), dto.nameStreet(), dto.number(), dto.neighborhood(),
				dto.complement(), dto.city(), dto.cep());
		Address addressSaved = addressRepository.save(address);

		Woodwork woodwork = new Woodwork(dto.idWoodwork(), null, dto.login(), dto.password(), address, contact,
				dto.companyName(), dto.cnpj(), dto.description());
		Woodwork woodworkSaved = woodworkRepository.save(woodwork);

		return new AllWoodworkDTO(woodwork.getId(), woodwork.getCompanyName(), woodwork.getCnpj(),
				woodwork.getDescription(), woodwork.getAddress().getStreetName(), woodwork.getAddress().getNumber(),
				woodwork.getAddress().getComplement(), woodwork.getAddress().getNeighborhood(),
				woodwork.getAddress().getCity(), woodwork.getAddress().getCep(), woodwork.getContact().getNetWork(),
				woodwork.getContact().getEmail(), woodwork.getContact().getPhoneNumber(), woodwork.getLogin(),
				woodwork.getPassword());
	}

	public void delete(Long id) {

		if (!woodworkRepository.existsById(id))
			throw new WoodworkNotFoundException("Woodwork " + id + " was not found");

		woodworkRepository.deleteById(id);
	}

	public AllWoodworkDTO findById(Long id) {
		Woodwork woodwork = woodworkRepository.findById(id)
				.orElseThrow(() -> new WoodworkNotFoundException("Client " + id + " was not found"));

		return new AllWoodworkDTO(woodwork.getId(), woodwork.getCompanyName(), woodwork.getCnpj(),
				woodwork.getDescription(), woodwork.getAddress().getStreetName(), woodwork.getAddress().getNumber(),
				woodwork.getAddress().getComplement(), woodwork.getAddress().getNeighborhood(),
				woodwork.getAddress().getCity(), woodwork.getAddress().getCep(), woodwork.getContact().getNetWork(),
				woodwork.getContact().getEmail(), woodwork.getContact().getPhoneNumber(), woodwork.getLogin(),
				woodwork.getPassword());
	}

	public List<WoodworkProjection> findAll() {
		return woodworkRepository.findWoodworks();
	}

	public void update(WoodworkDTO woodworkDTO, Long id) {
		
	}

	/*
	 * public void update(WoodworkDTO woodworkDTO, Long id) {
	 * 
	 * Woodwork woodwork = woodworkRepository.findById(id) .orElseThrow(() -> new
	 * WoodworkNotFoundException("Woodwork " + id + " was not found"));
	 * 
	 * if (woodworkDTO.cpnj().equals(woodwork.getCnpj()) &&
	 * woodworkDTO.companyName().equals(woodwork.getCompanyName())) {
	 * woodwork.setCompanyName(woodworkDTO.companyName());
	 * woodwork.setDescription(woodworkDTO.description());
	 * woodwork.setCnpj(woodworkDTO.cpnj()); woodworkRepository.save(woodwork);
	 * return; }
	 * 
	 * if (woodworkRepository.existsByCnpj(woodworkDTO.cpnj())) throw new
	 * WoodworkCnpjRegisteredException("Cnpj " + woodworkDTO.cpnj() +
	 * " is already registered");
	 * 
	 * woodwork.setCompanyName(woodworkDTO.companyName());
	 * woodwork.setDescription(woodworkDTO.description());
	 * woodwork.setCnpj(woodworkDTO.cpnj()); woodworkRepository.save(woodwork); }
	 * 
	 * 
	 * 
	 * public ProfileWoodworkFullEditProjection findById(Long id) { return
	 * woodworkRepository.findById(id) .orElseThrow(() -> new
	 * WoodworkNotFoundException("Woodwork " + id + " was not found")); }
	 * 
	 * public ProfileWoodworkForEditProjection findByCnpj(String cnpj) { return
	 * woodworkRepository.findByCnpj(cnpj) .orElseThrow(() -> new
	 * WoodworkNotFoundException("Woodwork " + cnpj + " was not found")); }
	 * 
	 * public java.util.List<ProfileWoodworkForEditProjection>
	 * findByCompanyName(String companyName) {
	 * java.util.List<ProfileWoodworkForEditProjection> woodwork =
	 * woodworkRepository.findByCompanyName(companyName);
	 * 
	 * if (woodwork.isEmpty()) throw new WoodworkNotFoundException("Woodwork " +
	 * companyName + " was not found"); return woodwork; }
	 * 
	 * 
	 */

}