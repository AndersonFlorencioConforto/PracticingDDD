package dev.anderson.praticandoddd.infrastructure.repositories;

import dev.anderson.praticandoddd.domain.entity.Product;
import dev.anderson.praticandoddd.infrastructure.db.model.ProductModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProductRepositoryGatewayTest {

    @Autowired
    private ProductRepositoryJpa productRepositoryJpa;

    @Autowired
    private ProductRepositoryGateway productRepositoryGateway;

    @Test
    void create() {
        Product product = new Product("1", "Produto 1", 10.0);
        productRepositoryGateway.create(product);
        ProductModel productModel = productRepositoryJpa.findById("1").get();
        assertEquals(productModel.getId(), product.getId());
        assertEquals(productModel.getName(), product.getName());
        assertEquals(productModel.getPrice(), product.getPrice());
    }

    @Test
    void test() {
        Assertions.assertNotNull(productRepositoryJpa);
        Assertions.assertNotNull(productRepositoryGateway);
    }

    @Test
    void update() {
        Product product = new Product("1", "Produto 1", 10.0);
        productRepositoryGateway.create(product);
        ProductModel productModel = productRepositoryJpa.findById("1").get();
        assertEquals(productModel.getId(), product.getId());
        assertEquals(productModel.getName(), product.getName());
        assertEquals(productModel.getPrice(), product.getPrice());

        product.changePrice(20.0);
        productRepositoryGateway.update(product);
        productModel = productRepositoryJpa.findById("1").get();
        assertEquals(productModel.getId(), product.getId());
        assertEquals(productModel.getName(), product.getName());
        assertEquals(productModel.getPrice(), product.getPrice());
    }

    @Test
    void findById() {
        Product product = new Product("1", "Produto 1", 10.0);
        productRepositoryGateway.create(product);
        ProductModel productModel = productRepositoryJpa.findById("1").get();

        Product byId = productRepositoryGateway.findById(productModel.getId());
        assertEquals(byId.getId(), productModel.getId());
        assertEquals(byId.getName(), productModel.getName());
        assertEquals(byId.getPrice(), productModel.getPrice());
    }

    @Test
    void findAll() {
        Product product = new Product("1", "Produto 1", 10.0);
        productRepositoryGateway.create(product);
        Product product2 = new Product("2", "Produto 2", 20.0);
        productRepositoryGateway.create(product2);
        Product product3 = new Product("3", "Produto 3", 30.0);
        productRepositoryGateway.create(product3);

        assertEquals(productRepositoryGateway.findAll().size(), 3);
    }

}