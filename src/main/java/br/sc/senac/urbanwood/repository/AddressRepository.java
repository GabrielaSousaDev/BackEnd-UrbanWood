package br.sc.senac.urbanwood.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.sc.senac.urbanwood.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

	boolean existsByCep(String cep);
	/*
	Optional<AddressProjection> findAddressById(Long id);

    boolean existsByStreetAndNumber(String street, Integer number);
    
    List<ProfileWoodworkForEditProjection> findByWoodworkNeighborhood(String neighborhood);
*/
}
