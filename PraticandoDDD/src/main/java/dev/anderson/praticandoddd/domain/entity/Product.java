package dev.anderson.praticandoddd.domain.entity;

public class Product {

    private String id;
    private String name;
    private double price;

    public Product(String id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
        this.validate();
    }

    public static Product with(String id, String name, double price){
        return new Product(id, name, price);
    }

    public void validate(){
        if(this.id == null || this.id.trim().equals("")){
            throw new IllegalArgumentException("Id do cliente é obrigatório");
        }
        if (this.name == null || this.name.trim().equals("")){
            throw new IllegalArgumentException("Nome do cliente é obrigatório");
        }
        if (this.price <= 0){
            throw new IllegalArgumentException("Preço do produto é obrigatório");
        }
    }

    public void changeName(String name){
        this.name = name;
        this.validate();
    }

    public void changePrice(double price){
        this.price = price;
        this.validate();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
