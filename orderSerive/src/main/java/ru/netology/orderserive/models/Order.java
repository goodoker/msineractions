package ru.netology.orderserive.models;

import java.util.List;
import java.util.Objects;

public class Order {
    private int id;
    private int userId;
    private double totalCost;
    private String currency;
    private List<OrderItem> orderItems;

    public Order() {
    }

    public Order(int id, int userId, String currency, List<OrderItem> orderItems) {
        this.id = id;
        this.userId = userId;
        this.currency = currency;
        this.orderItems = orderItems;
        this.setTotalCost();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost() {
        double cost = 0;
        for (OrderItem oi : this.getOrderItems()){
            cost += ( oi.getPrice() * oi.getQuantity());
        }
        this.totalCost = cost;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "OrderHeader{" +
                "id=" + id +
                ", UserId=" + userId +
                ", totalCost=" + totalCost +
                ", currency='" + currency + '\'' +
                ", orderItems=" + orderItems +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order that = (Order) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
