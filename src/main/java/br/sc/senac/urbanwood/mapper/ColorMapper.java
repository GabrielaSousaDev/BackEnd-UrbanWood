package br.sc.senac.urbanwood.mapper;

import org.springframework.stereotype.Service;

import br.sc.senac.urbanwood.dto.ColorDTO;
import br.sc.senac.urbanwood.model.Color;

@Service
public class ColorMapper {

	 public ColorDTO toDTO(Color color) {
	        return new ColorDTO(color.getId(), color.getName(), color.getBrand());
	    }

	    public Color toEntity(ColorDTO dto) {
	        return new Color(dto.id(), dto.name(), dto.brand());
	    }
}
