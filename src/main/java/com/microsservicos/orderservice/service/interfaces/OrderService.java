package com.microsservicos.orderservice.service.interfaces;

import com.microsservicos.orderservice.dto.OrderRequest;
import com.microsservicos.orderservice.entity.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(OrderRequest request);

    public List<Order> listAll();
}
