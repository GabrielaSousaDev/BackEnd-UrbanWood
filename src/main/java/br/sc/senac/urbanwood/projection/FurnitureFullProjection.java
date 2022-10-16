package br.sc.senac.urbanwood.projection;

import br.sc.senac.urbanwood.model.Image;

public interface FurnitureFullProjection {

     String getName();
	
	 Double getPrice();
	

	 String getDescription();
	
	 Double getFurnitureSize();

	 Image getImage();
			 
	 interface ImageProjection{
		 
		 byte[] getCode();
	 }
	
}
