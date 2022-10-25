package br.sc.senac.urbanwood.mapper;

import br.sc.senac.urbanwood.dto.furniture.FurnitureDTO;
import br.sc.senac.urbanwood.enumeration.Color;
import br.sc.senac.urbanwood.enumeration.Environment;
import br.sc.senac.urbanwood.enumeration.SizeFurniture;
import br.sc.senac.urbanwood.model.Furniture;
import br.sc.senac.urbanwood.model.Woodwork;
import org.springframework.stereotype.Service;

@Service
public class FurnitureMapper {

	 public FurnitureDTO toDTO(Furniture furniture) {
	        return new FurnitureDTO(furniture.getId(),furniture.getName(), furniture.getPrice(),
	        furniture.getDescription(),furniture.getFurnitureSize(),furniture.getEnvironment(),
					furniture.getColor(), furniture.getWoodwork());

	    }
	    public Furniture toEntity(FurnitureDTO dto) {
	        return new Furniture(dto.idFurniture(), dto.name(), dto.price(), dto.description(),
					dto.sizeFurniture(), dto.environment(),dto.color(),
					dto.woodwork());
	    }

}
