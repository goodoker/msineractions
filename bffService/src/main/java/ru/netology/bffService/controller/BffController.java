package ru.netology.bffService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.bffService.models.BffResponse;
import ru.netology.bffService.service.BffService;

import java.util.Optional;

@RestController
@RequestMapping("/api/site-bff/user")
public class BffController {
    private final BffService bffService;

    @Autowired
    public BffController(BffService bffService) {
        this.bffService = bffService;
    }

    @GetMapping("/{userId}")
    public Optional<BffResponse> getUserAndOrdersByUserId(@PathVariable int userId) {
        return bffService.getUserAndOrdersByUserId(userId);
    }
}
