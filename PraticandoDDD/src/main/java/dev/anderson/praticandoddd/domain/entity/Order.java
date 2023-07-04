package dev.anderson.praticandoddd.domain.entity;

import java.util.List;

public class Order {
    private String id;
    private String customerId;
    private List<OrderItem> items;
    private Double total;

    public Order(String id, String customerId, List<OrderItem> items) {
        this.id = id;
        this.customerId = customerId;
        this.items = items;
        this.total = this.total();
        this.validate();
    }

    public String toString() {
        return this.id + ", " + this.customerId + ", " + this.items.toString();
    }

    public Double total() {
        return this.items
                .stream()
                .mapToDouble(OrderItem::orderItemTotal)
                .sum();

    }

    public void validate(){
        if(this.id == null || this.id.trim().equals("")){
            throw new IllegalArgumentException("Id do pedido é obrigatório");
        }
        if(this.customerId == null || this.customerId.trim().equals("")){
            throw new IllegalArgumentException("Id do cliente é obrigatório");
        }
        if(this.items == null || this.items.isEmpty()){
            throw new IllegalArgumentException("Itens do pedido é obrigatório");
        }
        if (this.items.stream().anyMatch(item -> item.getQuantity() <= 0)){
            throw new IllegalArgumentException("Quantidade do item é obrigatório");
        }
    }
}
