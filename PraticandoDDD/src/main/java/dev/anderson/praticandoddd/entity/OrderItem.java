package dev.anderson.praticandoddd.entity;

public class OrderItem {
    private String id;
    private String name;
    private Double price;

    public OrderItem(String id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.validate();
    }

    public String toString(){
        return this.id + ", " + this.name + ", " + this.price;
    }

    public Double getPrice() {
        return price;
    }

    public void validate(){
        if(this.name == null || this.name.trim().equals("")){
            throw new IllegalArgumentException("Nome do item é obrigatório");
        }
        if (this.id == null || this.id.trim().equals("")){
            throw new IllegalArgumentException("Id do item é obrigatório");
        }
        if (this.price == null || this.price <= 0){
            throw new IllegalArgumentException("Preço do item é obrigatório");
        }
    }
}
