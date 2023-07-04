package dev.anderson.praticandoddd.service;

import dev.anderson.praticandoddd.domain.entity.Product;
import dev.anderson.praticandoddd.domain.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class ProductServiceTest {

    @Test
    void givenAValidPriceWhenCallAllProductsShouldReturnAllProducts() {
        var product1 = new Product("1", "Produto 1", 10.00);
        var product2 = new Product("2", "Produto 2", 20.00);
        var ArrayProducts = Arrays.asList(product1, product2);

        ProductService.increasePrice(ArrayProducts, 100);
        Assertions.assertEquals(20.00, product1.getPrice());
        Assertions.assertEquals(40.00, product2.getPrice());
    }
}
