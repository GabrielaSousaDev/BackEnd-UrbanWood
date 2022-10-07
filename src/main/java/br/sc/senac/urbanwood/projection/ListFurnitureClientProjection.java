package br.sc.senac.urbanwood.projection;

import br.sc.senac.urbanwood.model.Image;

public interface ListFurnitureClientProjection {

	String getName();

	Double getPrice();

	Image getImage();

	interface ImageProjection {

		byte[] getCode();
	}
}
