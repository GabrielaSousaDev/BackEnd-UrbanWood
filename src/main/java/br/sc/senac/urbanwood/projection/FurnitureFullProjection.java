package br.sc.senac.urbanwood.projection;

import java.util.List;

import br.sc.senac.urbanwood.model.Image;

public interface FurnitureFullProjection {

     String getName();
	
	 Double getPrice();
	

	 String getDescription();
	
	 Double getFurnitureSize();

	 Image getImage();
	
	 List<ColorProjection> getColor();
	 
	 interface ColorProjection{
		 
		 String getName();
		 String getBrand();
	 }
	 
	 interface ImageProjection{
		 
		 byte[] getCode();
	 }
	
}
