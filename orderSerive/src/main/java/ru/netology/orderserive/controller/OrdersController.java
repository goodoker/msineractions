package ru.netology.orderserive.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.orderserive.models.Order;
import ru.netology.orderserive.service.OrdersService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {
    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return ordersService.getAllOrders();
    }

    @GetMapping("/{orderId}")
    public Optional<Order> getOrderById(@PathVariable int orderId) {
        Optional<Order> res = ordersService.getOrderById(orderId);
        if (res.isPresent()) return res;
        return Optional.empty();
    }

    @GetMapping("/by-user/{userId}")
    public List<Order> getOrdersByUserId(@PathVariable int userId) {
        return ordersService.getOdersByUserId(userId);
    }
}
