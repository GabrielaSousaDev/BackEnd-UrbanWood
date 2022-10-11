package br.sc.senac.urbanwood.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.sc.senac.urbanwood.model.Address;
import br.sc.senac.urbanwood.projection.AddressProjection;
import br.sc.senac.urbanwood.projection.ProfileWoodworkForEditProjection;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

	Optional<AddressProjection> findAddressById(Long id);

    boolean existsByStreetAndNumber(String street, Integer number);
    
    List<ProfileWoodworkForEditProjection> findByWoodworkNeighborhood(String neighborhood);

}
