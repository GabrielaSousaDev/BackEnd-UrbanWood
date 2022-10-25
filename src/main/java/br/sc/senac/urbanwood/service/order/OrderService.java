package br.sc.senac.urbanwood.service.order;

import br.sc.senac.urbanwood.dto.order.OrderDTO;
import br.sc.senac.urbanwood.model.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {

    void update(Order order, Long id);
    void delete(Long id);

}
