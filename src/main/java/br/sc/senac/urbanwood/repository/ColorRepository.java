package br.sc.senac.urbanwood.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.sc.senac.urbanwood.projection.ColorProjection;

@Repository
public interface ColorRepository extends JpaRepository<Long, Id> {
	
	Optional<ColorProjection> findColorById(Long id);

	List<ColorProjection> findColorByNameColor(String nameColor);

	List<ColorProjection> findColorByBrand(String brand);

}
