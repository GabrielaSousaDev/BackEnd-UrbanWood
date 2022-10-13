package br.sc.senac.urbanwood.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.sc.senac.urbanwood.dto.EnvironmentDTO;
import br.sc.senac.urbanwood.model.Environment;
import br.sc.senac.urbanwood.projection.EnvironmentProjection;

@Repository
public interface EnvironmentRepository extends JpaRepository<Long, Id> {

	Optional<EnvironmentProjection> findById(Long id);

	EnvironmentDTO save(EnvironmentDTO livingAreaDTO);

	void update(EnvironmentDTO environmentDTO, Long id);

	void delete(Long id);

	Environment save(Environment environment1);

	static boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	List<EnvironmentProjection> listByWoodworkById(Long id);

}
