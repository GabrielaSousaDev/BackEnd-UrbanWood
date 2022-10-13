package br.sc.senac.urbanwood.service.order;

import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
/*
    private final OrderRepository orderRepository;
    private final FurnitureRepository furnitureRepository;
    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderRepository orderRepository, FurnitureRepository furnitureRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.furnitureRepository = furnitureRepository;
        this.orderMapper = orderMapper;
    }

    public OrderDTO save(OrderCreateDTO orderCreateDTO) {

        OrderRepository order = orderMapper.toEntity(orderCreateDTO);

        if (orderCreateDTO.priceOrder() <= 0)
            throw new OrderInvalidException("Price " + orderCreateDTO.priceOrder() + " is invalid");

        order.setInitialDate(LocalDate.now());
        if (!order.getInitialDate().isBefore(orderCreateDTO.finalDate()))
            throw new OrderInvalidException("Invalid Date " + orderCreateDTO.finalDate());

        for (Long idFurniture : orderCreateDTO.idFurnitures()) {
            Furniture furniture = furnitureRepository.findById(idFurniture)
                    .orElseThrow(() -> new OrderNotFoundException("Furniture " + idFurniture + " was not found"));
            order.getFurniture().add(furniture);
        }

        OrderRepository orderSaved = orderRepository.save(order);
        return orderMapper.toDTO(orderSaved);
    }

    public void update(OrderCreateDTO orderCreateDTO, Long id) {

        OrderRepository order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order " + id + " was not found"));

        if (orderCreateDTO.priceOrder() < 0)
            throw new OrderInvalidException("Price " + orderCreateDTO.priceOrder() + " is invalid");

        if (!order.getInitialDate().isBefore(orderCreateDTO.finalDate()))
            throw new OrderNotFoundException("Invalid Date " + orderCreateDTO.finalDate());

        for (Long idFurniture : orderCreateDTO.idFurnitures()) {
            order.setFurnitures(new ArrayList<>());
            Furniture furniture = furnitureRepository.findById(idFurniture)
                    .orElseThrow(() -> new OrderNotFoundException("Order " + idFurniture + " was not found"));
            order.getFurniture().add(furniture);
        }

        order.setStatus(orderCreateDTO.status());
        order.setPayment(orderCreateDTO.payment());
        order.setFinalDate(orderCreateDTO.finalDate());
        order.setPriceOrder(orderCreateDTO.priceOrder());
        orderRepository.save(order);
    }

    public void delete(Long id) {
        if (!orderRepository.existsById(id))
            throw new OrderNotFoundException("Order " + id + " was not found");
        orderRepository.deleteById(id);
    }

    public OrderProjection findById(Long id) {
        return orderRepository.findOrderById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order " + id + " was not found"));
    }

    public List<OrderProjection> findByInitialDate(LocalDate initialDate) {
        List<OrderProjection> order = orderRepository.findOrderByInitialDate(initialDate);

        if (order.isEmpty())
            throw new OrderNotFoundException("Order " + initialDate + " was not found");
        return order;
    }

    //Screen

    public Page<OrderProjectionW12> findW12OrderByInitialDate(Pageable pageable, Integer page) {
        pageable = PageRequest.of(page, 3, Sort.Direction.ASC, "initialDate" );
        return orderRepository.findOrderW12OrderByInitialDate(pageable);
    }

    public OrderProjectionW13 findW13ById(Long id) {
        return orderRepository.findOrderW13ById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order " + id + " was not found"));
    }*/
}
