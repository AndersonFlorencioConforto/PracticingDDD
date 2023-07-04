package dev.anderson.praticandoddd.infrastructure.repositories;

import dev.anderson.praticandoddd.domain.entity.Product;
import dev.anderson.praticandoddd.domain.repositories.ProductGateway;
import dev.anderson.praticandoddd.infrastructure.db.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductRepositoryGateway implements ProductGateway {

    @Autowired
    private ProductRepositoryJpa productRepositoryJpa;


    @Override
    public void create(Product entity) {
        productRepositoryJpa.save(ProductModel.from(entity));
    }

    @Override
    public void update(Product entity) {
        productRepositoryJpa.save(ProductModel.from(entity));
    }

    @Override
    public Product findById(String id) {
        return productRepositoryJpa.findById(id).map(ProductModel::toAggregate).get();
    }

    @Override
    public List<Product> findAll() {
        return productRepositoryJpa.findAll()
                .stream()
                .map(ProductModel::toAggregate)
                .toList();
    }
}
