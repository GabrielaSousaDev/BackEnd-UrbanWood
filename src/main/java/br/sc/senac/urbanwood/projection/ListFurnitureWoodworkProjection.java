package br.sc.senac.urbanwood.projection;

import br.sc.senac.urbanwood.model.Image;

public interface ListFurnitureWoodworkProjection {

	String getName();

	Image getImage();

	interface ImageProjection {

		byte[] getCode();
	}
}
