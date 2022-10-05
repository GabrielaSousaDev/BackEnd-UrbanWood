package br.sc.senac.urbanwood.mapper;

import br.sc.senac.urbanwood.controller.Order;

public class OrderMapper {
	
	 public OrderDTO toDTO(Order order) {
	        return new OrderDTO(order.getId(), order.getPrice(), order.getStatus(), order.getPayment(), order.getStartDate(), order.getEndDate());
	    }

	    public Order toEntity(OrderCreateDTO dto) {
	        return new Order(dto.id(), dto.priceOrder(), dto.status(), dto.payment(), dto.startDate(), dto.endDate());
	    }

}
