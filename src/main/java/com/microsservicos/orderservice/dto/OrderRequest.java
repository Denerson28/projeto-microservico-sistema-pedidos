package com.microsservicos.orderservice.dto;

import java.util.List;

public class OrderRequest {
    public Long customerId;
    public List<Item> items;

    public static class Item {
        public Long productId;
        public Integer quantity;
    }
}
