package br.sc.senac.urbanwood.mapper;

import org.springframework.stereotype.Service;

import br.sc.senac.urbanwood.model.User;
import br.sc.senac.urbanwood.model.Woodwork;

@Service
public class WoodworkMapper {

	public WoodworkDTO toDTO(Woodwork woodwork) {
        return new WoodworkDTO(woodwork.getId(), woodwork.getCompanyName(), woodwork.getDescription(), woodwork.getEnvironment(), 
        		woodwork.getOrder());
    }

    public Woodwork toEntity(WoodworkDTO dto) {
        return new Woodwork(dto.id(), dto.companyName, dto.description, dto.environment, dto.order);
    }

}
