package br.sc.senac.urbanwood.service.environment;

import org.springframework.stereotype.Service;

import br.sc.senac.urbanwood.dto.environment.AllEnvironmentDTO;


@Service
public interface EnvironmentService {

    AllEnvironmentDTO save(AllEnvironmentDTO dto);

    void update(AllEnvironmentDTO dto, Long id);

    void delete(Long id);
    
    boolean existsById(Long id);
}