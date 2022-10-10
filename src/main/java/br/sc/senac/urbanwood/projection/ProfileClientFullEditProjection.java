package br.sc.senac.urbanwood.projection;

import br.sc.senac.urbanwood.model.Address;
import br.sc.senac.urbanwood.model.Contact;
import br.sc.senac.urbanwood.model.Image;
import br.sc.senac.urbanwood.model.User;

public interface ProfileClientFullEditProjection {

	String getFirstName();

	String getLastName();

	String getCpf();

	User getUser();
	

	interface UserProjection {

		String getLogin();

		String getPassword();

		Address getAddress();

		Contact getContact();

		Image getImage();
		
		
	}
}
