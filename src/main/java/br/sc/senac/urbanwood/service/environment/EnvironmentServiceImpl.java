package br.sc.senac.urbanwood.service.environment;

import org.springframework.stereotype.Service;


@Service
public class EnvironmentServiceImpl implements EnvironmentService {
/*
	private final EnvironmentMapper environmentMapper;
	private final EnvironmentRepository environmentRepository;

	public EnvironmentServiceImpl(EnvironmentRepository environmentRepository, EnvironmentMapper environmentMapper) {
		this.environmentRepository = environmentRepository;
		this.environmentMapper = environmentMapper;
	}

	public EnvironmentDTO save(EnvironmentDTO environmentDTO) {

		Environment environment = environmentMapper.toEntity(environmentDTO);
		Environment environmentSaved = environmentRepository.save(environment);
		return environmentMapper.toDTO(environmentSaved);
	}

	public void update(EnvironmentDTO environmentDTO, Long id) {

		Environment environment = (Environment) environmentRepository.findById(id)
				.orElseThrow(() -> new EnvironmentNotFoundException("Environment " + id + " was not found"));

		environment.setName(environmentDTO.name());
		environmentRepository.save(environment);
	}

	public void delete(Long id) {
		if (!EnvironmentRepository.existsById(id))
			throw new EnvironmentNotFoundException("Environment " + id + " was not found");
		environmentRepository.delete(id);
	}

	public EnvironmentProjection findById(Long id) {
		return environmentRepository.findById(id)
				.orElseThrow(() -> new EnvironmentNotFoundException("Environment " + id + " was not found"));

	}

	public List<EnvironmentProjection> listByWoodworkById(Long id) {
		List<EnvironmentProjection> environment = environmentRepository.listByWoodworkById(id);
		return environment;
	}
*/
}