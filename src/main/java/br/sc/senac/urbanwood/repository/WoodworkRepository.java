package br.sc.senac.urbanwood.repository;

import br.sc.senac.urbanwood.model.Woodwork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WoodworkRepository extends JpaRepository<Woodwork, Long> {


/*
	boolean existsById(Long id);

	boolean existsByCnpj(String cnpj);
	
    List<WoodworkDTO> findByCompanyName(String companyName);
    
    WoodworkDTO findByCnpj(String cnpj);

    List<WoodworkDTO> findByPhoneNumber(String phoneNumber);

	Woodwork save(Woodwork woodwork);
*/

}
