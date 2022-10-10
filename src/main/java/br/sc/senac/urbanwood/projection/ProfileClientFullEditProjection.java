package br.sc.senac.urbanwood.projection;

import java.util.List;

import br.sc.senac.urbanwood.model.Address;
import br.sc.senac.urbanwood.model.Contact;
import br.sc.senac.urbanwood.model.Image;
import br.sc.senac.urbanwood.model.User;
import br.sc.senac.urbanwood.projection.FurnitureFullProjection.ColorProjection;

public interface ProfileClientFullEditProjection {

	String getFirstName();

	String getLastName();

	String getCnpj();

	User getUser();
	List<ColorProjection> getColor();

	interface UserProjection {

		String getLogin();

		String getPassword();

		Address getAddress();

		Contact getContact();

		Image getImage();
		
		
	}
}
