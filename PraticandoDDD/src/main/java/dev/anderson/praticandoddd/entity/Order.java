package dev.anderson.praticandoddd.entity;

import java.util.List;

public class Order {
    private String id;
    private String customerId;
    private List<OrderItem> items;

    public Order(String id, String customerId, List<OrderItem> items) {
        this.id = id;
        this.customerId = customerId;
        this.items = items;
    }

    public String toString() {
        return this.id + ", " + this.customerId + ", " + this.items.toString();
    }

    public Double amount() {
        return this.items
                .stream()
                .mapToDouble(OrderItem::getPrice)
                .sum();

    }
}
