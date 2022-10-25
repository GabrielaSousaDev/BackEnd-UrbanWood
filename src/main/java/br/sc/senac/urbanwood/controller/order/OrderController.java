package br.sc.senac.urbanwood.controller.order;

import br.sc.senac.urbanwood.dto.furniture.FurnitureDTO;
import br.sc.senac.urbanwood.dto.order.OrderDTO;
import br.sc.senac.urbanwood.model.Order;
import br.sc.senac.urbanwood.service.order.OrderServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/order")
public class OrderController {
    private final OrderServiceImpl orderServiceImpl;

    public OrderController(OrderServiceImpl orderServiceImpl) {
        this.orderServiceImpl = orderServiceImpl;
    }
    @PostMapping
    public ResponseEntity<OrderDTO> addOrder(@RequestBody Order order) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderServiceImpl.save(order));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateOrder(@RequestBody Order order, @PathVariable(value = "id") Long id) {
        orderServiceImpl.update(order, id);
        return ResponseEntity.status(HttpStatus.OK).body("Order updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable(value = "id") Long id) {
        orderServiceImpl.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Order deleted successfully");
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getFindById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(orderServiceImpl.findById(id));
    }
}
