package session15.session15.service;

import session15.session15.model.dto.request.OrderCreateDTO;
import session15.session15.model.entity.Order;
import session15.session15.utils.OrderStatus;

import java.util.List;

public interface OrderService {

    Order create(OrderCreateDTO req, String email);

    List<Order> myOrders(String email);

    List<Order> findAll();

    Order updateStatus(Long id, OrderStatus status);
}