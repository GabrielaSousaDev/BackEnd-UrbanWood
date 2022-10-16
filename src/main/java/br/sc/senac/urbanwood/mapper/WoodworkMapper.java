package br.sc.senac.urbanwood.mapper;

import org.springframework.stereotype.Service;

import br.sc.senac.urbanwood.dto.woodwork.AllWoodworkDTO;
import br.sc.senac.urbanwood.model.Woodwork;

@Service
public class WoodworkMapper {

	public AllWoodworkDTO toDTO(Woodwork woodwork) {
        return new AllWoodworkDTO(woodwork.getId(), woodwork.getCompanyName(), woodwork.getCnpj(),
				woodwork.getDescription(), woodwork.getAddress().getStreetName(), woodwork.getAddress().getNumber(),
				woodwork.getAddress().getComplement(), woodwork.getAddress().getNeighborhood(),
				woodwork.getAddress().getCity(), woodwork.getAddress().getCep(), woodwork.getContact().getNetWork(),
				woodwork.getContact().getEmail(), woodwork.getContact().getPhoneNumber(), woodwork.getLogin(),
				woodwork.getPassword());
    }

  /*  public Woodwork toEntity(WoodworkDTO dto) {
        return new Woodwork(dto.id(), dto.companyName(), dto.description(), dto.environment(), dto.order());
    }*/

}
