package br.sc.senac.urbanwood.repository;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.sc.senac.urbanwood.projection.ProfileWoodworkForEditProjection;
import br.sc.senac.urbanwood.projection.ProfileWoodworkFullEditProjection;

@Repository
public interface WoodworkRepository extends JpaRepository<Long, Id> {

	boolean existsById(Long id);

	boolean existsByCnpj(String cnpj);

	boolean existsByLogin(String login);
	
	List<ProfileWoodworkFullEditProjection> findById(Long id); 

    List<ProfileWoodworkForEditProjection> findByCompanyName(String companyName);
    
    List<ProfileWoodworkForEditProjection> findByCnpj(String cnpj);

    List<ProfileWoodworkForEditProjection> findByPhoneNumber(String phoneNumber);
    
    List<ProfileWoodworkForEditProjection> findByNeighborhood(String neighborhood);
}
