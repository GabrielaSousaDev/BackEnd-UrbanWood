package br.sc.senac.urbanwood.dto;

import java.util.List;

import br.sc.senac.urbanwood.model.Furniture;
import br.sc.senac.urbanwood.model.Image;

public record EnvironmentDTO(Long id, String name, Image image, List<Furniture> furniture) {

}
