package com.microsservicos.orderservice.service;

import com.microsservicos.orderservice.client.CustomerClient;
import com.microsservicos.orderservice.dto.OrderRequest;
import com.microsservicos.orderservice.entity.Order;
import com.microsservicos.orderservice.entity.OrderItem;
import com.microsservicos.orderservice.repository.OrderRepository;
import com.microsservicos.orderservice.service.interfaces.OrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final CustomerClient customerClient;

    public OrderServiceImpl(OrderRepository repository, CustomerClient customerClient) {
        this.repository = repository;
        this.customerClient = customerClient;
    }

    @Override
    public Order createOrder(OrderRequest request) {
        if (!customerClient.isCustomerValid(request.customerId)) {
            throw new IllegalArgumentException("Cliente inválido");
        }

        Order order = new Order();
        order.setCustomerId(request.customerId);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("CREATED");

        order.setItems(request.items.stream().map(i -> {
            OrderItem item = new OrderItem();
            item.setProductId(i.productId);
            item.setQuantity(i.quantity);
            item.setPrice(50.0); // mock
            return item;
        }).collect(Collectors.toList()));

        return repository.save(order);
    }

    public List<Order> listAll() {
        return repository.findAll();
    }
}
