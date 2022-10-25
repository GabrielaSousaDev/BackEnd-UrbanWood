package br.sc.senac.urbanwood.mapper;

import br.sc.senac.urbanwood.dto.woodwork.WoodworkDTO;
import br.sc.senac.urbanwood.enumeration.Environment;
import br.sc.senac.urbanwood.model.Furniture;
import br.sc.senac.urbanwood.model.Order;
import br.sc.senac.urbanwood.model.Woodwork;
import org.springframework.stereotype.Service;

@Service
public class WoodworkMapper {

	public WoodworkDTO toDTO(Woodwork woodwork) {
        return new WoodworkDTO(woodwork.getIdUser(), woodwork.getLogin(), woodwork.getPassword(),
				woodwork.getAddress(),woodwork.getContact(),woodwork.getImage(),woodwork.getCompanyName(),
				woodwork.getDescription(), woodwork.getCnpj(),
				woodwork.getFurniture(), woodwork.getOrder(),woodwork.getEnvironment() );
    }

}
