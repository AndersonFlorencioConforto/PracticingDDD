package dev.anderson.praticandoddd.infrastructure.repositories;

import dev.anderson.praticandoddd.domain.entity.Product;
import dev.anderson.praticandoddd.domain.repositories.ProductGateway;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductRepository implements ProductGateway {

    private final ProductRepositoryJpa productRepositoryJpa;

    public ProductRepository(ProductRepositoryJpa productRepositoryJpa) {
        this.productRepositoryJpa = productRepositoryJpa;
    }

    @Override
    public void create(Product entity) {

    }
    @Override
    public void update(Product entity) {

    }

    @Override
    public Product findById(String id) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }
}
