package br.sc.senac.urbanwood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.sc.senac.urbanwood.dto.environment.AllEnvironmentDTO;
import br.sc.senac.urbanwood.model.Environment;

@Repository
public interface EnvironmentRepository extends JpaRepository<Environment, Long> {


	AllEnvironmentDTO save(AllEnvironmentDTO dto);

	void update(AllEnvironmentDTO AllEnvironmentDTO, Long id);

	void delete(Long id);


}
