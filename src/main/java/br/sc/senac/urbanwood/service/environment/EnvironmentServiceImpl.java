package br.sc.senac.urbanwood.service.environment;

import java.util.List;

import org.springframework.stereotype.Service;

import br.sc.senac.urbanwood.dto.EnvironmentDTO;
import br.sc.senac.urbanwood.exception.woodwork.WoodworkNotFoundException;
import br.sc.senac.urbanwood.mapper.EnvironmentMapper;
import br.sc.senac.urbanwood.model.Environment;
import br.sc.senac.urbanwood.repository.EnvironmentRepository;


@Service
public class EnvironmentServiceImpl implements EnvironmentService {

	private final EnvironmentMapper environmentMapper;
	private final EnvironmentRepository environmentRepository;

	public EnvironmentServiceImpl(EnvironmentRepository environmentRepository, EnvironmentMapper environmentMapper) {
		this.environmentRepository = environmentRepository;
		this.environmentMapper = environmentMapper;
	}

	public EnvironmentDTO save(EnvironmentDTO environmentDTO) {

		Environment environment = environmentRepository.findById(environmentDTO.id()).orElseThrow(
				() -> new WoodworkNotFoundException("Environment " + livingAreaDTO.idWoodwork() + " was not found"));

		Environment environment1 = environmentMapper.toEntity(environmentDTO);
		Environment environmentSaved = environmentRepository.save(environment1);
		return environmentMapper.toDTO(environmentSaved);
	}

	public void update(LivingAreaDTO livingAreaDTO, Long id) {

		LivingArea livingArea = livingAreaRepository.findById(id)
				.orElseThrow(() -> new LivingAreaNotFoundException("Living Area " + id + " was not found"));

		livingArea.setNameLivingArea(livingAreaDTO.nameLivingArea());
		livingAreaRepository.save(livingArea);
	}

	public void delete(Long id) {
		if (!livingAreaRepository.existsById(id))
			throw new LivingAreaNotFoundException("Living Area " + id + " was not found");
		livingAreaRepository.deleteById(id);
	}

	public LivingAreaProjection findById(Long id) {
		return livingAreaRepository.findLivingAreaById(id)
				.orElseThrow(() -> new LivingAreaNotFoundException("Living Area " + id + " was not found"));

	}

	public List<LivingAreaProjection> findByNameLivingArea(String nameLivingArea) {
		List<LivingAreaProjection> livingArea = livingAreaRepository.findLivingAreaByNameLivingArea(nameLivingArea);

		if (livingArea.isEmpty())
			throw new LivingAreaNotFoundException("Living Area " + nameLivingArea + " was not found");
		return livingArea;
	}

	// Screen

	public List<LivingAreaProjectionC16> findC16OrderByName() {
		List<LivingAreaProjectionC16> livingArea = livingAreaRepository.findAllOrderByName();

		if (livingArea.isEmpty())
			throw new LivingAreaNotFoundException("Was not found");
		return livingArea;
	}
}