package br.sc.senac.urbanwood.mapper;

import org.springframework.stereotype.Service;

import br.sc.senac.urbanwood.dto.EnvironmentDTO;
import br.sc.senac.urbanwood.dto.environment.AllEnvironmentDTO;
import br.sc.senac.urbanwood.model.Environment;

@Service
public class EnvironmentMapper {

	public AllEnvironmentDTO toDTO(Environment environment) {
		return new AllEnvironmentDTO(environment.getId(), environment.getName());
	}

	/*public Environment toEntity(AllEnvironmentDTO dto) {
		return new Environment(dto.idEnvironment(), dto.name());
	}*/
}
