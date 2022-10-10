package br.sc.senac.urbanwood.service.woodwork;

import org.springframework.stereotype.Service;

import antlr.collections.List;
import br.sc.senac.urbanwood.dto.WoodworkDTO;
import br.sc.senac.urbanwood.exception.client.ClientLoginRegisteredException;
import br.sc.senac.urbanwood.exception.woodwork.WoodworkCnpjInvalidException;
import br.sc.senac.urbanwood.exception.woodwork.WoodworkCnpjRegisteredException;
import br.sc.senac.urbanwood.exception.woodwork.WoodworkNotFoundException;
import br.sc.senac.urbanwood.mapper.WoodworkMapper;
import br.sc.senac.urbanwood.model.Woodwork;
import br.sc.senac.urbanwood.projection.ProfileWoodworkForEditProjection;
import br.sc.senac.urbanwood.projection.ProfileWoodworkFullEditProjection;
import br.sc.senac.urbanwood.repository.AddressRepository;
import br.sc.senac.urbanwood.repository.ContactRepository;
import br.sc.senac.urbanwood.repository.WoodworkRepository;

@Service
public class WoodworkServiceImpl implements WoodworkService {

	private final WoodworkRepository woodworkRepository;
	private final WoodworkMapper woodworkMapper;
	private final AddressRepository addressRepository;
	private final ContactRepository contactRepository;

	public WoodworkServiceImpl(WoodworkRepository woodworkRepository, WoodworkMapper woodworkMapper,
			AddressRepository addressRepository, ContactRepository contactRepository) {
		this.woodworkRepository = woodworkRepository;
		this.woodworkMapper = woodworkMapper;
		this.addressRepository = addressRepository;
		this.contactRepository = contactRepository;
	}

	public WoodworkDTO save(WoodworkDTO woodworkDTO) {

		if (woodworkRepository.existsByCnpj(woodworkDTO.cpnj()))
			throw new WoodworkCnpjRegisteredException("Cnpj " + woodworkDTO.cpnj() + " is already registered");

		Woodwork woodwork = woodworkMapper.toEntity(woodworkDTO);
		Woodwork woodworkSaved = woodworkRepository.save(woodwork);
		return woodworkMapper.toDTO(woodworkSaved);
	}

	public void update(WoodworkDTO woodworkDTO, Long id) {

		Woodwork woodwork = woodworkRepository.findById(id)
				.orElseThrow(() -> new WoodworkNotFoundException("Woodwork " + id + " was not found"));

		if (CNPJValidator.isCNPJ(woodworkDTO.cpnj()))
			throw new WoodworkCnpjInvalidException("Cnpj " + woodworkDTO.cpnj() + " is invalid");

		if (woodworkDTO.cpnj().equals(woodwork.getCnpj()) && woodworkDTO.login().equals(woodwork.getLogin())) {
			woodwork.setCompanyName(woodworkDTO.companyName());
			woodwork.setDescription(woodworkDTO.description());
			woodwork.setCnpj(woodworkDTO.cpnj());
			woodwork.setLogin(woodworkDTO.login());
			woodwork.setPassword(woodworkDTO.password());
			woodwork.setImage(woodworkDTO.image());
			woodworkRepository.save(woodwork);
			return;
		}

		if (woodworkRepository.existsByCnpj(woodworkDTO.cpnj()))
			throw new WoodworkCnpjRegisteredException("Cnpj " + woodworkDTO.cpnj() + " is already registered");

		if (woodworkRepository.existsByLogin(woodworkDTO.login()))
			throw new ClientLoginRegisteredException("Login " + woodworkDTO.login() + " is already registered");

		woodwork.setCompanyName(woodworkDTO.companyName());
		woodwork.setDescription(woodworkDTO.description());
		woodwork.setCnpj(woodworkDTO.cpnj());
		woodwork.setLogin(woodworkDTO.login());
		woodwork.setPassword(woodworkDTO.password());
		woodwork.setImage(woodworkDTO.image());
		woodworkRepository.save(woodwork);
	}

	public void delete(Long id) {
		if (!woodworkRepository.existsById(id))
			throw new WoodworkNotFoundException("Woodwork " + id + " was not found");
		woodworkRepository.delete(id);
	}

	public ProfileWoodworkFullEditProjection findById(Long id) {
		return woodworkRepository.findById(id)
				.orElseThrow(() -> new WoodworkNotFoundException("Woodwork " + id + " was not found"));
	}

	public List<ProfileWoodworkForEditProjection> findByCnpj(String cnpj) {
		return woodworkRepository.findByCnpj(cnpj)
				.orElseThrow(() -> new WoodworkNotFoundException("Woodwork " + cnpj + " was not found"));
	}

	public List<ProfileWoodworkForEditProjection> findByCompanyName(String companyName) {
		List<ProfileWoodworkForEditProjection> woodwork = woodworkRepository.findByCompanyName(companyName);

		if (woodwork.isEmpty())
			throw new WoodworkNotFoundException("Woodwork " + companyName + " was not found");
		return woodwork;
	}

	
}