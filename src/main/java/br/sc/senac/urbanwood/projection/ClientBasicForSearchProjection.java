package br.sc.senac.urbanwood.projection;

import br.sc.senac.urbanwood.model.Address;
import br.sc.senac.urbanwood.model.Contact;
import br.sc.senac.urbanwood.model.User;

public interface ClientBasicForSearchProjection {

	Long getId();

	String getFirstName();

	String getLastName();

	User getUser();

	interface UserProjection {

		Address getAddress();
		Contact getContact();

		interface AddressProjection {

			String getNeighborhood();

			String getCity();

		}
		interface ContactProjection {

			String getPhoneNumber();
		}

	}
}
