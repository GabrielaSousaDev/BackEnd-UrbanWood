package br.sc.senac.urbanwood.dto;

import java.time.LocalDate;
import java.util.List;

import br.sc.senac.urbanwood.model.Client;
import br.sc.senac.urbanwood.model.Furniture;
import br.sc.senac.urbanwood.model.Payment;
import br.sc.senac.urbanwood.model.Status;
import br.sc.senac.urbanwood.model.Woodwork;

public record OrderDTO(Long id, Double price, LocalDate startDate, LocalDate endDate, Status status, Payment payment,
		Client client, Woodwork woodwork, List<Furniture> furnitures) {

}
