package dev.anderson.praticandoddd.domain.entity;

public class OrderItem {
    private String id;
    private String name;
    private Double price;

    private String productId;
    private Integer quantity;

    public OrderItem(String id, String name, Double price, String productId, Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productId = productId;
        this.quantity = quantity;
        this.validate();
    }

    public String toString(){
        return this.id + ", " + this.name + ", " + this.price;
    }

    public double orderItemTotal(){
        return this.price * this.quantity;
    }

    public Integer getQuantity() {
        return quantity;
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
        if (this.quantity == null || this.quantity <= 0){
            throw new IllegalArgumentException("Quantidade do item é obrigatório");
        }
        if (this.productId == null || this.productId.trim().equals("")){
            throw new IllegalArgumentException("Id do produto é obrigatório");
        }
    }
}
