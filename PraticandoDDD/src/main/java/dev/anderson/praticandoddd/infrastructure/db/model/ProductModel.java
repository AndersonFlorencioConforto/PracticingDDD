package dev.anderson.praticandoddd.infrastructure.db.model;

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
}
