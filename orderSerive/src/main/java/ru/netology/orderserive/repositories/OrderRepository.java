package ru.netology.orderserive.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.netology.orderserive.models.Order;
import ru.netology.orderserive.models.OrderItem;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class OrderRepository {
    private final OrderItemsRepository orderItemsRepository;
    private final Map<Integer, Order> orders = new ConcurrentHashMap<>();

    @Autowired
    public OrderRepository(OrderItemsRepository orderItemsRepository) {
        this.orderItemsRepository = orderItemsRepository;
        orderInit();
    }

    public List<Order> getAllOrders(){
        return new ArrayList<>(orders.values());
    }

    public Optional<Order> getOrderByOrderId(int orderId){
        return Optional.ofNullable(orders.get(orderId));
    }

    public List<Order> getOrdersByUserId(int userId){
        return getAllOrders().stream()
                .filter(order -> order.getUserId() == userId)
                .collect(Collectors.toUnmodifiableList());
    }

    private void orderInit(){
        List<OrderItem> itemsList1 = orderItemsRepository.getOrderItemsById(1);
        Order oh1 = new Order(1, 1, "RUB", itemsList1);

        List<OrderItem> itemsList2 = orderItemsRepository.getOrderItemsById(2);
        Order oh2 = new Order(2, 1, "RUB", itemsList2);

        List<OrderItem> itemsList3 = orderItemsRepository.getOrderItemsById(3);
        Order oh3 = new Order(3, 2, "RUB", itemsList3);

        orders.put(1, oh1);
        orders.put(2, oh2);
        orders.put(3, oh3);
    }


}
