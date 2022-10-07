package br.sc.senac.urbanwood.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.sc.senac.urbanwood.projection.EnvironmentProjection;
@Repository
public interface EnvironmentRepository extends JpaRepository<Long, Id>{
	
	 Optional<EnvironmentProjection> findLivingAreaById(Long id);

	    List<EnvironmentProjection> findLivingAreaByNameLivingArea(String nameLivingArea);

	    //Screen

	    @Query(value = """
	            select l.nameLivingArea as nameLivingArea, l.image as image
	            from LivingArea l
	            order by l.nameLivingArea
	            """)
	    List<EnvironmentProjection> findAllOrderByName();
}
