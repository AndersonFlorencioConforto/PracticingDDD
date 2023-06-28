package dev.anderson.praticandoddd.entity;

public class OrderItem {
    private String id;
    private String name;
    private Double price;

    public OrderItem(String id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String toString(){
        return this.id + ", " + this.name + ", " + this.price;
    }

    public Double getPrice() {
        return price;
    }
}
