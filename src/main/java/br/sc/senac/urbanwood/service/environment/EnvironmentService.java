package br.sc.senac.urbanwood.service.environment;

import org.springframework.stereotype.Service;

import br.sc.senac.urbanwood.dto.EnvironmentDTO;
import br.sc.senac.urbanwood.projection.EnvironmentProjection;


@Service
public interface EnvironmentService {

    EnvironmentDTO save(EnvironmentDTO livingAreaDTO);

    void update(EnvironmentDTO environmentDTO, Long id);

    void delete(Long id);

    EnvironmentProjection findById(Long id);
    
    

}