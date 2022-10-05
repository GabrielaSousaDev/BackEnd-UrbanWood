package br.sc.senac.urbanwood.mapper;

import org.springframework.stereotype.Service;

import br.sc.senac.urbanwood.model.Furniture;

@Service
public class FurnitureMapper {

	 public FurnitureDTO toDTO(Furniture furniture) {
	        return new FurnitureDTO(furniture.getId(), furniture.getDescription(), furniture.getImagem(), 
	        		furniture.getName(), furniture.getPrice(), furniture.getFurnitureSize(), furniture.getColor());
	    }

	    public Furniture toEntity(FurnitureDTO dto) {
	        return new Furniture(dto.id(), dto.description(), dto.image(), dto.name(), dto.price(), dto.furnitureSize(), dto.color());
	    }
}
