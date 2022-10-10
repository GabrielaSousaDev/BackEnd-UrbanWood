package br.sc.senac.urbanwood.projection;

import br.sc.senac.urbanwood.model.Address;
import br.sc.senac.urbanwood.model.Contact;
import br.sc.senac.urbanwood.model.Image;

public interface UserProjection {

	Long getId();

	String getLogin();

	String getPassword();

	Address getAddress();

	Contact getContact();

	Image getImage();

	interface AddressProjection {
		String getStreet();

		Integer getNumber();

		String getComplement();

		String getNeighborhood();

		String getProvince();

		String getCity();

		String getCep();
	}

	interface ContactProjection {

		String getEmail();

		String getPhoneNumber();

		String getNetWork();
	}

	interface ImageProjection {
		byte[] getCode();
	}
}
