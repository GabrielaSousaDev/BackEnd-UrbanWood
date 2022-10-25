package br.sc.senac.urbanwood.service.address;

import br.sc.senac.urbanwood.dto.adress.AddressDTO;
import br.sc.senac.urbanwood.dto.woodwork.WoodworkDTO;

import java.util.List;

public interface AddressService  {

    AddressDTO save(AddressDTO addressDTO);

    void update(AddressDTO addressDTO, Long id);

    void delete(Long id);

    AddressDTO findById(Long id);
    
    //List<WoodworkDTO> findByWoodworkNeighborhood(String neighborhood);

}