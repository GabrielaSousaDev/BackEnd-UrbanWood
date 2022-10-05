package br.sc.senac.urbanwood.mapper;

import org.springframework.stereotype.Service;

import br.sc.senac.urbanwood.dto.EnvironmentDTO;
import br.sc.senac.urbanwood.model.Environment;

@Service
public class EnvironmentMapper {

	public EnvironmentDTO toDTO(Environment environment) {
		return new EnvironmentDTO(environment.getId(), environment.getName(), environment.getImage(),
				environment.getFurniture());
	}

	public Environment toEntity(EnvironmentDTO dto) {
		return new Environment(dto.id(), dto.name(), dto.image(), dto.furniture());
	}
}
