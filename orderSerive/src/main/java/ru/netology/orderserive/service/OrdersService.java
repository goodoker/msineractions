package ru.netology.orderserive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.orderserive.models.Order;
import ru.netology.orderserive.repositories.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrdersService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    public List<Order> getOdersByUserId(int userId) {
        return orderRepository.getOrdersByUserId(userId);
    }

    public Optional<Order> getOrderById(int orderId) {
        return  orderRepository.getOrderByOrderId(orderId);
    }
}
