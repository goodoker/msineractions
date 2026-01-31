package ru.netology.bffService.models;

import java.util.List;

public class BffResponse {
    private User user;
    private List<Order> orderList;

    public BffResponse() {
    }

    public BffResponse(User user, List<Order> orderList) {
        this.user = user;
        this.orderList = orderList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "BffResponse{" +
                "user=" + user +
                ", orderList=" + orderList +
                '}';
    }
}
