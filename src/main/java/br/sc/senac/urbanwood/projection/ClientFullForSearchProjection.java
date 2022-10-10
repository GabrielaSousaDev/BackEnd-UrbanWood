package br.sc.senac.urbanwood.projection;

import java.time.LocalDate;
import java.util.List;

import br.sc.senac.urbanwood.enumeration.Status;
import br.sc.senac.urbanwood.model.Address;
import br.sc.senac.urbanwood.model.Contact;
import br.sc.senac.urbanwood.model.Image;
import br.sc.senac.urbanwood.model.User;

public interface ClientFullForSearchProjection {

	String getFirstName();

	String getLastName();

	String getCnpj();

	User getUser();

	List<OrderBasicProjection> getOrder();

	interface UserProjection {

		String getLogin();

		String getPassword();

		Address getAddress();

		Contact getContact();

		Image getImage();
	}

	interface OrderBasicProjection {
		Long getId();

		Double getPrice();

		Status getStatus();

		LocalDate getStartDate();
	}

}
