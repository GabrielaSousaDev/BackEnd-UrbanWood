package br.sc.senac.urbanwood.repository;

import java.util.Optional;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.sc.senac.urbanwood.dto.EnvironmentDTO;
import br.sc.senac.urbanwood.projection.EnvironmentProjection;

@Repository
public interface EnvironmentRepository extends JpaRepository<Long, Id> {

	Optional<EnvironmentProjection> findLivingAreaById(Long id);

	EnvironmentDTO save(EnvironmentDTO livingAreaDTO);

	void update(EnvironmentDTO environmentDTO, Long id);

	void delete(Long id);

}
