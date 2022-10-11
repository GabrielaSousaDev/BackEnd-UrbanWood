package br.sc.senac.urbanwood.service.woodwork;

import java.util.List;

import org.springframework.stereotype.Service;

import br.sc.senac.urbanwood.dto.WoodworkDTO;
import br.sc.senac.urbanwood.model.Woodwork;
import br.sc.senac.urbanwood.projection.ProfileWoodworkForEditProjection;
import br.sc.senac.urbanwood.projection.ProfileWoodworkFullEditProjection;

@Service
public interface WoodworkService {

    WoodworkDTO save(WoodworkDTO woodworkDTO);

    void update(WoodworkDTO woodworkDTO, Long id);

    void delete(Long id);

    ProfileWoodworkFullEditProjection findById(Long id); 

    List<ProfileWoodworkForEditProjection> findByCompanyName(String companyName);
    
    ProfileWoodworkForEditProjection findByCnpj(String cnpj);

    List<ProfileWoodworkForEditProjection> findByPhoneNumber(String phoneNumber);
    
    List<ProfileWoodworkForEditProjection> findByNeighborhood(String neighborhood);

	

}