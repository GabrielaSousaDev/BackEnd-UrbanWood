package br.sc.senac.urbanwood.projection;

import br.sc.senac.urbanwood.model.Image;

public interface ProfileClientProjection {
	
	 String getFirstName();
	
	 String getLastName();
	 
	 Image 	getImage();
	 
	 interface ImageProjection {

			byte[] getCode();
		}
}
