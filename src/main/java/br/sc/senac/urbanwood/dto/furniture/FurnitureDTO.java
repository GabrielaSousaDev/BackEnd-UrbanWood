package br.sc.senac.urbanwood.dto.furniture;

import br.sc.senac.urbanwood.enumeration.Color;
import br.sc.senac.urbanwood.enumeration.Environment;
import br.sc.senac.urbanwood.enumeration.SizeFurniture;
import br.sc.senac.urbanwood.model.Woodwork;

public record FurnitureDTO(Long idFurniture,
						   String name,
						   Double price,
						   String description,
						   SizeFurniture sizeFurniture,
						   Environment environment,
						   Color color,
						   Woodwork woodwork) {}
