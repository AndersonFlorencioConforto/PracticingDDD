package dev.anderson.praticandoddd.infrastructure.db.model;

import dev.anderson.praticandoddd.domain.entity.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class ProductModel {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "price",nullable = false)
    private double price;

    public ProductModel() {

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

    private ProductModel(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product toAggregate() {
        return Product.with(this.id, this.name, this.price);
    }

    public static ProductModel from(Product product){
        return new ProductModel(product.getId(), product.getName(), product.getPrice());
    }

}
