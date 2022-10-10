package br.sc.senac.urbanwood.projection;

import br.sc.senac.urbanwood.model.Address;
import br.sc.senac.urbanwood.model.Contact;
import br.sc.senac.urbanwood.model.Image;
import br.sc.senac.urbanwood.model.User;

public interface ProfileWoodworkFullEditProjection {
	
	String getCompanyName();

	String getCnpj();
	
	String getDescription();

	User getUser();
	
	
	interface UserProjection {

		String getLogin();

		String getPassword();

		Address getAddress();

		Contact getContact();

		Image getImage();
		
		
	}

}
