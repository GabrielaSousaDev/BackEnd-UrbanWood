package br.sc.senac.urbanwood.service.address;

import br.sc.senac.urbanwood.dto.AddressDTO;
import br.sc.senac.urbanwood.projection.AddressProjection;

public interface AddressService {

    AddressDTO save(AddressDTO addressDTO);

    void update(AddressDTO addressDTO, Long id);

    void delete(Long id);

    AddressProjection findById(Long id);

    
}