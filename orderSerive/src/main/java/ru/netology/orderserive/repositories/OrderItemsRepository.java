package ru.netology.orderserive.repositories;

import org.springframework.stereotype.Repository;
import ru.netology.orderserive.models.OrderItem;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class OrderItemsRepository {
    private final Map<Integer, OrderItem> orderItems = new ConcurrentHashMap<>();

    public OrderItemsRepository() {
        itemsRepositoryInit();
    }

    public List<OrderItem> getAllOrderItems(){
        return new ArrayList<>(orderItems.values());
    }

    public List<OrderItem> getOrderItemsById(int orderId){
        return getAllOrderItems().stream()
                .filter(item -> item.getOrderId() == orderId)
                .collect(Collectors.toUnmodifiableList());
    }

    private void itemsRepositoryInit(){
        OrderItem oa1= new OrderItem(1, 1, "Гречка", 1.520, 100.99);
        OrderItem oa2= new OrderItem(2, 1, "Рис", 1.415, 120.99);
        OrderItem oa3= new OrderItem(3, 2, "Яйца", 2, 20.99);
        OrderItem oa4= new OrderItem(4, 3, "Печенье", 4, 990.99);
        OrderItem oa5= new OrderItem(5, 3, "Кешью", 2, 1900.99);
        orderItems.put(1, oa1);
        orderItems.put(2, oa2);
        orderItems.put(3, oa3);
        orderItems.put(4, oa4);
        orderItems.put(5, oa5);
    }
}
