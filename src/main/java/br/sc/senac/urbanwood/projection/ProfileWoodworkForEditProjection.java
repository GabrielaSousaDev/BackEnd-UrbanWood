package br.sc.senac.urbanwood.projection;

import br.sc.senac.urbanwood.model.Image;
import br.sc.senac.urbanwood.model.User;

public interface ProfileWoodworkForEditProjection {

	String getCompanyName();

	String getCnpj();

	User getUser();

	interface UserProjection {

		Image getImage();

	}

}
