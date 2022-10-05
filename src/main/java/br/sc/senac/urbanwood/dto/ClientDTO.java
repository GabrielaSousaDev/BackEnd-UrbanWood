package br.sc.senac.urbanwood.dto;

import java.util.List;

import br.sc.senac.urbanwood.model.Order;

public record ClientDTO(Long id, String cpf, String firstName, String lastName, List<Order> order) {

}
