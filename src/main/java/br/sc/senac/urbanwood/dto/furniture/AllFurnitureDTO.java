package br.sc.senac.urbanwood.dto.furniture;

import java.util.List;

import br.sc.senac.urbanwood.model.Color;

public record AllFurnitureDTO(Long idFurniture, String name, Double price, String description, Double furnitureSize,	
		List<Color> idColor) {

}
	