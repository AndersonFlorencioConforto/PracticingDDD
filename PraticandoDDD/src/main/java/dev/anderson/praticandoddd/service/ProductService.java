package dev.anderson.praticandoddd.service;

import dev.anderson.praticandoddd.entity.Product;

import java.util.List;

public class ProductService {

    public static void increasePrice(List<Product> products, Integer percentage) {
        products.forEach(product -> product.changePrice(
                product.getPrice() + (product.getPrice() * percentage / 100)
        ));

    }
}
