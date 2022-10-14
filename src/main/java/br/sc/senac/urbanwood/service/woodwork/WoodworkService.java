package br.sc.senac.urbanwood.service.woodwork;

import org.springframework.stereotype.Service;

import br.sc.senac.urbanwood.dto.woodwork.AllWoodworkDTO;

@Service
public interface WoodworkService {

    AllWoodworkDTO save(AllWoodworkDTO dto);

    void delete(Long id);
/*    void update(WoodworkDTO woodworkDTO, Long id);

   

    ProfileWoodworkFullEditProjection findById(Long id); 

    List<ProfileWoodworkForEditProjection> findByCompanyName(String companyName);
    
    ProfileWoodworkForEditProjection findByCnpj(String cnpj);

    List<ProfileWoodworkForEditProjection> findByPhoneNumber(String phoneNumber);
    
    List<ProfileWoodworkForEditProjection> findByNeighborhood(String neighborhood);

	*/

}