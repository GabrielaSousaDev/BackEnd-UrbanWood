package br.sc.senac.urbanwood.service.woodwork;

import java.util.List;

import org.springframework.stereotype.Service;

import br.sc.senac.urbanwood.dto.woodwork.AllWoodworkDTO;
import br.sc.senac.urbanwood.projection.woodwork.WoodworkProjection;

@Service
public interface WoodworkService {

	AllWoodworkDTO save(AllWoodworkDTO dto);

	void delete(Long id);

	void update(AllWoodworkDTO allWoodworkDTO, Long id);

	AllWoodworkDTO findById(Long id);
	
	List<WoodworkProjection> findAll();

	/*
	 * 
	 * 
	 * 
	 * ProfileWoodworkFullEditProjection findById(Long id);
	 * 
	 * List<ProfileWoodworkForEditProjection> findByCompanyName(String companyName);
	 * 
	 * ProfileWoodworkForEditProjection findByCnpj(String cnpj);
	 * 
	 * List<ProfileWoodworkForEditProjection> findByPhoneNumber(String phoneNumber);
	 * 
	 * List<ProfileWoodworkForEditProjection> findByNeighborhood(String
	 * neighborhood);
	 * 
	 */

}