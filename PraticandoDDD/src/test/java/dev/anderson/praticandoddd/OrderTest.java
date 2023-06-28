package dev.anderson.praticandoddd;

import dev.anderson.praticandoddd.entity.Order;
import dev.anderson.praticandoddd.entity.OrderItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderTest {

    @Test
    void givenInvalidIdWhenCreateOrderThenThrowException() {
        var expectedId = "";
        var expectedCustomerId = "123";
        var expectedError = assertThrows(IllegalArgumentException.class,
                () -> new Order(expectedId, expectedCustomerId, List.of()));

        Assertions.assertEquals("Id do pedido é obrigatório", expectedError.getMessage());
    }

    @Test
    void givenInvalidCustomerIdWhenCreateOrderThenThrowException() {
        var expectedId = "123";
        var expectedCustomerId = "";
        var expectedError = assertThrows(IllegalArgumentException.class,
                () -> new Order(expectedId, expectedCustomerId, List.of()));

        Assertions.assertEquals("Id do cliente é obrigatório", expectedError.getMessage());
    }

    @Test
    void givenInvalidItemsWhenCreateOrderThenThrowException() {
        var expectedId = "123";
        var expectedCustomerId = "123";
        List<OrderItem> expectedItems = List.of();
        var expectedError = assertThrows(IllegalArgumentException.class,
                () -> new Order(expectedId, expectedCustomerId,expectedItems));

        Assertions.assertEquals("Itens do pedido é obrigatório", expectedError.getMessage());
    }

    @Test
    void givenAValidOrderWhenCreateThenCreate() {
        var expectedId = "123";
        var expectedCustomerId = "123";

        var expectedItem1 = new OrderItem("123", "item 1", 10.00);
        var expectedItem2 = new OrderItem("123", "item 2", 20.00);

        var expectedItems = List.of(expectedItem1, expectedItem2);
        var order = new Order(expectedId, expectedCustomerId, expectedItems);

        Assertions.assertEquals(30.0, order.total());
    }
}
