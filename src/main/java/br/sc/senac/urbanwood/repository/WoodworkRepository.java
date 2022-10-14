package br.sc.senac.urbanwood.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.sc.senac.urbanwood.model.Woodwork;
import br.sc.senac.urbanwood.projection.client.ClientProjection;
import br.sc.senac.urbanwood.projection.woodwork.WoodworkProjection;

@Repository
public interface WoodworkRepository extends JpaRepository<Woodwork, Long> {
	
	@Query(value = "SELECT w.cnpj AS cnpj, w.companyName AS companyName, w.description AS description FROM woodwork w")
	List<WoodworkProjection> findWoodworks();

/*
	boolean existsById(Long id);

	boolean existsByCnpj(String cnpj);
	
    List<ProfileWoodworkForEditProjection> findByCompanyName(String companyName);
    
    ProfileWoodworkForEditProjection findByCnpj(String cnpj);

    List<ProfileWoodworkForEditProjection> findByPhoneNumber(String phoneNumber);

	Woodwork save(Woodwork woodwork);
*/

}
