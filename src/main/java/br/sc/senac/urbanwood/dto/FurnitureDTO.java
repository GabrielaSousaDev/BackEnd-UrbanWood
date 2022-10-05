package br.sc.senac.urbanwood.dto;

import java.util.List;

import br.sc.senac.urbanwood.model.Color;
import br.sc.senac.urbanwood.model.Image;

public record FurnitureDTO(Long id, String name, Double price, Image imagem, String description, Double furnitureSize,
		List<Color> color) {

}
