package dev.anderson.praticandoddd.entity;

import dev.anderson.praticandoddd.domain.entity.Order;
import dev.anderson.praticandoddd.domain.entity.OrderItem;
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

        var expectedItem1 = new OrderItem("123", "item 1", 10.00, "123", 2);
        var expectedItem2 = new OrderItem("123", "item 2", 20.00, "123", 2);

        var expectedItems = List.of(expectedItem1, expectedItem2);
        var order = new Order(expectedId, expectedCustomerId, expectedItems);

        Assertions.assertEquals(60.0, order.total());
    }

    @Test
    void givenAInvalidQuantityWhenCreateThenThrowException() {
        var expectedId = "123";
        var expectedCustomerId = "123";

        var expectedError = Assertions.assertThrows(IllegalArgumentException.class,() -> {
            var expectedItem1 = new OrderItem("123", "item 1", 10.00, "123", 0);
            var expectedItem2 = new OrderItem("123", "item 2", 20.00, "123", 2);

            var expectedItems = List.of(expectedItem1, expectedItem2);
            new Order(expectedId, expectedCustomerId, expectedItems);
        });

        Assertions.assertEquals("Quantidade do item é obrigatório", expectedError.getMessage());
    }
}
