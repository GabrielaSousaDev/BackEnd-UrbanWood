package br.sc.senac.urbanwood.repository;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.sc.senac.urbanwood.dto.WoodworkDTO;
import br.sc.senac.urbanwood.model.Woodwork;
import br.sc.senac.urbanwood.projection.ProfileWoodworkForEditProjection;
import br.sc.senac.urbanwood.projection.ProfileWoodworkFullEditProjection;

@Repository
public interface WoodworkRepository extends JpaRepository<Long, Id> {

	boolean existsById(Long id);

	boolean existsByCnpj(String cnpj);
	
	ProfileWoodworkFullEditProjection findById(Long id); 

    List<ProfileWoodworkForEditProjection> findByCompanyName(String companyName);
    
    ProfileWoodworkForEditProjection findByCnpj(String cnpj);

    List<ProfileWoodworkForEditProjection> findByPhoneNumber(String phoneNumber);

	Woodwork save(Woodwork woodwork);


}
