package com.microsservicos.orderservice.controller;

import com.microsservicos.orderservice.dto.OrderRequest;
import com.microsservicos.orderservice.entity.Order;
import com.microsservicos.orderservice.service.OrderServiceImpl;
import com.microsservicos.orderservice.service.interfaces.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order create(@RequestBody OrderRequest request) {
        return orderService.createOrder(request);
    }

    @GetMapping
    public List<Order> list() {
        return ((OrderServiceImpl) orderService).listAll(); // se quiser listar aqui depois
    }
}
