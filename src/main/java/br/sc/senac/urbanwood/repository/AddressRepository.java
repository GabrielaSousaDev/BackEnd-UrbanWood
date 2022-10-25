package br.sc.senac.urbanwood.repository;


import br.sc.senac.urbanwood.dto.adress.AddressDTO;
import br.sc.senac.urbanwood.dto.woodwork.WoodworkDTO;
import br.sc.senac.urbanwood.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{


    Optional<AddressDTO> findAddressById(Long id);

   }
