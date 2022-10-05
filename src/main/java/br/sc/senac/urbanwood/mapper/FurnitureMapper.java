package br.sc.senac.urbanwood.mapper;

import org.springframework.stereotype.Service;

import br.sc.senac.urbanwood.dto.FurnitureDTO;
import br.sc.senac.urbanwood.model.Furniture;

@Service
public class FurnitureMapper {

	 public FurnitureDTO toDTO(Furniture furniture) {
	        return new FurnitureDTO(furniture.getId(),furniture.getName(), furniture.getPrice(), furniture.getDescription(),
	        		furniture.getFurnitureSize(), furniture.getImage(), furniture.getColor());
	    		
	    }
	

	    public Furniture toEntity(FurnitureDTO dto) {
	        return new Furniture(dto.id(), dto.description(), dto.furnitureSize(), dto.name(), dto.price(), dto.image(), dto.color());
	    }
}
