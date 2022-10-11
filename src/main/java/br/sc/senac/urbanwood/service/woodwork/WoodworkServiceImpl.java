package br.sc.senac.urbanwood.service.woodwork;

import org.springframework.stereotype.Service;

import antlr.collections.List;
import br.sc.senac.urbanwood.dto.WoodworkDTO;
import br.sc.senac.urbanwood.exception.woodwork.WoodworkCnpjRegisteredException;
import br.sc.senac.urbanwood.exception.woodwork.WoodworkNotFoundException;
import br.sc.senac.urbanwood.mapper.WoodworkMapper;
import br.sc.senac.urbanwood.model.Woodwork;
import br.sc.senac.urbanwood.projection.ProfileWoodworkForEditProjection;
import br.sc.senac.urbanwood.projection.ProfileWoodworkFullEditProjection;
import br.sc.senac.urbanwood.repository.WoodworkRepository;

@Service
public class WoodworkServiceImpl implements WoodworkService {

	private final WoodworkRepository woodworkRepository;
	private final WoodworkMapper woodworkMapper;

	public WoodworkServiceImpl(WoodworkRepository woodworkRepository, WoodworkMapper woodworkMapper) {
		this.woodworkRepository = woodworkRepository;
		this.woodworkMapper = woodworkMapper;
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

		if (woodworkDTO.cpnj().equals(woodwork.getCnpj())
				&& woodworkDTO.companyName().equals(woodwork.getCompanyName())) {
			woodwork.setCompanyName(woodworkDTO.companyName());
			woodwork.setDescription(woodworkDTO.description());
			woodwork.setCnpj(woodworkDTO.cpnj());
			woodworkRepository.save(woodwork);
			return;
		}

		if (woodworkRepository.existsByCnpj(woodworkDTO.cpnj()))
			throw new WoodworkCnpjRegisteredException("Cnpj " + woodworkDTO.cpnj() + " is already registered");

		woodwork.setCompanyName(woodworkDTO.companyName());
		woodwork.setDescription(woodworkDTO.description());
		woodwork.setCnpj(woodworkDTO.cpnj());
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

	public ProfileWoodworkForEditProjection findByCnpj(String cnpj) {
		return woodworkRepository.findByCnpj(cnpj)
				.orElseThrow(() -> new WoodworkNotFoundException("Woodwork " + cnpj + " was not found"));
	}

	public List findByCompanyName(String companyName) {
		List<ProfileWoodworkForEditProjection> woodwork = woodworkRepository.findByCompanyName(companyName);

		if (woodwork.isEmpty())
			throw new WoodworkNotFoundException("Woodwork " + companyName + " was not found");
		return woodwork;
	}

	@Override
	public java.util.List<ProfileWoodworkForEditProjection> findByCompanyName(String companyName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public java.util.List<ProfileWoodworkForEditProjection> findByPhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public java.util.List<ProfileWoodworkForEditProjection> findByNeighborhood(String neighborhood) {
		// TODO Auto-generated method stub
		return null;
	}

	
}