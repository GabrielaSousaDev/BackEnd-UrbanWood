package br.sc.senac.urbanwood.service.address;

import java.util.List;

import br.sc.senac.urbanwood.dto.AddressDTO;
import br.sc.senac.urbanwood.projection.AddressProjection;
import br.sc.senac.urbanwood.projection.ProfileWoodworkForEditProjection;

public interface AddressService {

    AddressDTO save(AddressDTO addressDTO);

    void update(AddressDTO addressDTO, Long id);

    void delete(Long id);

    AddressProjection findById(Long id);
    
    List<ProfileWoodworkForEditProjection> findByWoodworkNeighborhood(String neighborhood);


    
}