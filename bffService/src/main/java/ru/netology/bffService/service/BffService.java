package ru.netology.bffService.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.netology.bffService.models.BffResponse;
import ru.netology.bffService.models.Order;
import ru.netology.bffService.models.User;

import java.util.List;
import java.util.Optional;

@Service
public class BffService {
    @Value("${user.service.uri}")
    private String userServiceURI;
    @Value("${order.service.uri}")
    private String orderServiceURI;

    public User getUserById(int userId) {
        String uri = userServiceURI + "/" + userId;
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(uri, User.class);
        System.out.println(user);
        return user;
    }

    public List<Order> getOrderListByUserId(int userId) {
        String uri = orderServiceURI + "/" + userId;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Order>> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Order>>() {
                }
        );
        List<Order> orderList = response.getBody();
        System.out.println(orderList);
        return orderList;
    }

    public Optional<BffResponse> getUserAndOrdersByUserId(int userId) {
        Optional<User> user = Optional.ofNullable(getUserById(userId));
        if (user.isEmpty()) {
            Optional<BffResponse> response =Optional.empty();
            return response;
        }
        List<Order> orderList = getOrderListByUserId(userId);
        BffResponse bffResponse = new BffResponse(user.get(), orderList);
        return Optional.of(bffResponse);
    }
}
