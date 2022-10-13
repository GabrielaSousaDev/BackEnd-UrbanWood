package br.sc.senac.urbanwood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.sc.senac.urbanwood.model.Woodwork;

@Repository
public interface WoodworkRepository extends JpaRepository<Woodwork, Long> {
/*
	boolean existsById(Long id);

	boolean existsByCnpj(String cnpj);
	
    List<ProfileWoodworkForEditProjection> findByCompanyName(String companyName);
    
    ProfileWoodworkForEditProjection findByCnpj(String cnpj);

    List<ProfileWoodworkForEditProjection> findByPhoneNumber(String phoneNumber);

	Woodwork save(Woodwork woodwork);
*/

}
