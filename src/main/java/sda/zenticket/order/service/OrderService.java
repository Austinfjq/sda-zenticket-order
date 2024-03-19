package sda.zenticket.order.service;

import sda.zenticket.order.model.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);

    List<Order> getAllOrders();

    Order getOrderById(Long orderId);

    Order updateOrder(Long orderId, Order orderDetails);

    boolean deleteOrder(Long orderId);
}
