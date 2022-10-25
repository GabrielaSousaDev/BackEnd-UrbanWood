package br.sc.senac.urbanwood.service.order;

import br.sc.senac.urbanwood.dto.furniture.FurnitureDTO;
import br.sc.senac.urbanwood.dto.order.OrderDTO;
import br.sc.senac.urbanwood.exception.furniture.FurnitureNotFoundException;
import br.sc.senac.urbanwood.exception.order.OrderInvalidException;
import br.sc.senac.urbanwood.exception.order.OrderNotFoundException;
import br.sc.senac.urbanwood.mapper.OrderMapper;
import br.sc.senac.urbanwood.model.Furniture;
import br.sc.senac.urbanwood.model.Order;
import br.sc.senac.urbanwood.repository.FurnitureRepository;
import br.sc.senac.urbanwood.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final FurnitureRepository furnitureRepository;
    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderRepository orderRepository,
                            FurnitureRepository furnitureRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.furnitureRepository = furnitureRepository;
        this.orderMapper = orderMapper;
    }


    public OrderDTO save(Order order) {
        order.setStartDate(LocalDate.now());
        if (!order.getStartDate().isBefore(order.getEndDate()))
            throw new OrderInvalidException("Invalid Date " + order.getEndDate());
        return orderMapper.toDTO(orderRepository.save(order));
    }

    public void update(Order order, Long id) {

        Order orderToUpdate = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order " + id + " was not found"));

        if (orderToUpdate.getPrice()< 0)
            throw new OrderInvalidException("Price " + orderToUpdate.getPrice() + " is invalid");

        if (!orderToUpdate.getStartDate().isBefore(orderToUpdate.getEndDate()))
            throw new OrderNotFoundException("Invalid Date " + order.getEndDate());

        orderToUpdate.setStatus(order.getStatus());
        orderToUpdate.setPayment(order.getPayment());
        orderToUpdate.setStartDate(order.getStartDate());
        orderToUpdate.setEndDate(order.getEndDate());
        orderToUpdate.setPrice(order.getPrice());
        orderRepository.saveAndFlush(orderToUpdate);
    }

    public void delete(Long id) {
        if (!orderRepository.existsById(id))
            throw new OrderNotFoundException("Order " + id + " was not found");
        orderRepository.deleteById(id);
    }

    public OrderDTO findById(Long id) {
        Order orderFound = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order " + id + " was not found"));
        return orderMapper.toDTO(orderFound);
    }
}
