package br.sc.senac.urbanwood.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.sc.senac.urbanwood.model.Address;
import br.sc.senac.urbanwood.projection.AddressFullProjection;

@Repository
public interface AdressRepository extends JpaRepository<Address, Long>{

	Optional<AddressFullProjection> findAddressById(Long id);

    List<AddressFullProjection> findAddressByNeighborhood(String neighbor);

    boolean existsByStreetAndNumber(String street, Integer number);

}
