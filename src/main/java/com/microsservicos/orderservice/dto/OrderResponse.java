package com.microsservicos.orderservice.dto;

import java.time.LocalDateTime;
import java.util.List;

public class OrderResponse {
    public Long id;
    public Long customerId;
    public LocalDateTime orderDate;
    public String status;
    public List<Item> items;

    public static class Item {
        public Long productId;
        public Integer quantity;
        public Double price;
    }
}
