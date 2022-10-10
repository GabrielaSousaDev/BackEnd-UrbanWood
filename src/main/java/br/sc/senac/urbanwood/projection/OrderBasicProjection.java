package br.sc.senac.urbanwood.projection;

import java.time.LocalDate;

import br.sc.senac.urbanwood.enumeration.Status;

public interface OrderBasicProjection {

	Long getId();

	Double getPrice();

	Status getStatus();

	LocalDate getStartDate();

}
