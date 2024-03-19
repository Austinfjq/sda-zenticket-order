package sda.zenticket.order.service;

import org.springframework.stereotype.Service;
import sda.zenticket.order.model.Order;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public Order createOrder(Order order) {
        return null;
    }

    @Override
    public List<Order> getAllOrders() {
        return List.of(new Order(){{
            setId(1L);
        }});
    }

    @Override
    public Order getOrderById(Long orderId) {
        return null;
    }

    @Override
    public Order updateOrder(Long orderId, Order orderDetails) {
        return null;
    }

    @Override
    public boolean deleteOrder(Long orderId) {
        return false;
    }
}
