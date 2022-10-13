package br.sc.senac.urbanwood.service.environment;

import java.util.List;

import org.springframework.stereotype.Service;

import br.sc.senac.urbanwood.dto.EnvironmentDTO;
import br.sc.senac.urbanwood.projection.EnvironmentProjection;


@Service
public interface EnvironmentService {

    EnvironmentDTO save(EnvironmentDTO livingAreaDTO);

    void update(EnvironmentDTO environmentDTO, Long id);

    void delete(Long id);

    EnvironmentProjection findById(Long id);
    
    boolean existsById(Long id);
    
    List<EnvironmentProjection> listByWoodworkById(Long id);

}