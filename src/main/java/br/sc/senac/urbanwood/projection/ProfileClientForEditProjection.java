package br.sc.senac.urbanwood.projection;

import br.sc.senac.urbanwood.model.Image;
import br.sc.senac.urbanwood.model.User;

public interface ProfileClientForEditProjection {

	String getFirstName();

	String getLastName();

	String getCpf();

	User getUser();

	interface UserProjection {

		Image getImage();
		
		interface ImageProjection {
			byte[] getCode();
		}
	}
}
