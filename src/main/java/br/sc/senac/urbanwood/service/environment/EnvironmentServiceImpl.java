package br.sc.senac.urbanwood.service.environment;

import java.util.List;

import org.springframework.stereotype.Service;

import br.sc.senac.urbanwood.dto.EnvironmentDTO;
import br.sc.senac.urbanwood.exception.environment.EnvironmentNotFoundException;
import br.sc.senac.urbanwood.mapper.EnvironmentMapper;
import br.sc.senac.urbanwood.model.Environment;
import br.sc.senac.urbanwood.projection.EnvironmentProjection;
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

}