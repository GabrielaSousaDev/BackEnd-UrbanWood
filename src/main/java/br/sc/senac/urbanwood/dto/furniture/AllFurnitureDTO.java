package br.sc.senac.urbanwood.dto.furniture;

import br.sc.senac.urbanwood.model.Woodwork;

public record AllFurnitureDTO(Long idFurniture, String name, Double price, String description, Woodwork id_woodwork) {

}
	