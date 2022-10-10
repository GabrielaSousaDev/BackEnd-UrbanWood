package br.sc.senac.urbanwood.projection;

import java.time.LocalDate;
import java.util.List;

import br.sc.senac.urbanwood.enumeration.Payment;
import br.sc.senac.urbanwood.enumeration.Status;
import br.sc.senac.urbanwood.model.Client;
import br.sc.senac.urbanwood.model.Furniture;
import br.sc.senac.urbanwood.model.User;

public interface OrderFullProjection {

	Long getId();

	Double getPrice();

	Status getStatus();

	Payment getPayment();

	LocalDate getStartDate();

	LocalDate getEndDate();

	Client getClien();

	List<Furniture> getFurnitures();

	interface ClientFullForSearchProjection {

		String getFirstName();

		String getLastName();

		String getcpf();

		User getUser();
	}
}
