package br.sc.senac.urbanwood.dto;

import java.util.List;

import br.sc.senac.urbanwood.model.Color;
import br.sc.senac.urbanwood.model.Image;

public record FurnitureDTO(Long id, String name, Double price, String description, Double furnitureSize, Image image,
		List<Color> color) {

	

}
