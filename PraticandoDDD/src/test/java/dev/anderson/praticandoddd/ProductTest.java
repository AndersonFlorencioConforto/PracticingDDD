package dev.anderson.praticandoddd;

import dev.anderson.praticandoddd.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    void givenAInvalidIdWhenCreateThenThrowException() {
        var expectedId = "";
        var expectedName = "Produto 1";
        var expectedPrice = 10.00;
        var expectedError = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Product(expectedId, expectedName,expectedPrice);
        });
        Assertions.assertEquals("Id do cliente é obrigatório", expectedError.getMessage());
    }

    @Test
    void givenAInvalidNameWhenCreateThenThrowException() {
        var expectedId = "123";
        var expectedName = "";
        var expectedPrice = 10.00;
        var expectedError = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Product(expectedId, expectedName,expectedPrice);
        });
        Assertions.assertEquals("Nome do cliente é obrigatório", expectedError.getMessage());
    }

    @Test
    void givenAInvalidPriceWhenCreateThenThrowException() {
        var expectedId = "123";
        var expectedName = "Produto 1";
        var expectedPrice = 0.00;
        var expectedError = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Product(expectedId, expectedName,expectedPrice);
        });
        Assertions.assertEquals("Preço do produto é obrigatório", expectedError.getMessage());
    }

    @Test
    void givenAValidNameWhenCallChangeNameThenChangeName() {
        var expectedId = "123";
        var expectedName = "Produto 1";
        var expectedPrice = 10.00;
        var product = new Product(expectedId, expectedName,expectedPrice);

        Assertions.assertEquals(expectedName, product.getName());
        var newName = "Produto 2";
        product.changeName(newName);
        Assertions.assertEquals(newName, product.getName());
    }

    @Test
    void givenAValidProductWhenCallChangePriceThenChangePrice() {
        var expectedId = "123";
        var expectedName = "Produto 1";
        var expectedPrice = 10.00;
        var product = new Product(expectedId, expectedName,expectedPrice);

        Assertions.assertEquals(expectedPrice, product.getPrice());
        var newPrice = 20.00;
        product.changePrice(newPrice);
        Assertions.assertEquals(newPrice, product.getPrice());
    }
}
