package br.sc.senac.urbanwood.dto;

import java.util.List;

import br.sc.senac.urbanwood.model.Environment;
import br.sc.senac.urbanwood.model.Order;

public record WoodworkDTO(Long id, String companyName, String description, List<Order> order,
		List<Environment> environment) {

}
