package br.sc.senac.urbanwood.mapper;

import br.sc.senac.urbanwood.dto.OrderDTO;
import br.sc.senac.urbanwood.model.Order;

public class OrderMapper {

	public OrderDTO toDTO(Order order) {
		return new OrderDTO(order.getId(), order.getPrice(), order.getStatus(), order.getPayment(),
				order.getStartDate(), order.getEndDate(), order.getClient(), order.getWoodwork(),
				order.getFurnitures());
	}

	public Order toEntity(OrderDTO dto) {
		return new Order(dto.id(), dto.price(), dto.status(), dto.payment(), dto.startDate(), dto.endDate(),
				dto.client(), dto.woodwork(), dto.furnitures());
	}

}
