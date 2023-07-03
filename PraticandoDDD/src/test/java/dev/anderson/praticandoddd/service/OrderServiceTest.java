package dev.anderson.praticandoddd.service;

import dev.anderson.praticandoddd.entity.Order;
import dev.anderson.praticandoddd.entity.OrderItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class OrderServiceTest {


    @Test
    void givenAValidCommandWhenGetTotalAllOrdersThenReturnTotal() {

        var item1 = new OrderItem("123", "item 1", 100.00, "123", 1);
        var item2 = new OrderItem("1234", "item 2", 200.00, "123", 2);

        var order = new Order("123", "123", List.of(item1));
        var order2 = new Order("123", "123", List.of(item2));

        var total = OrderService.total(List.of(order, order2));
        Assertions.assertEquals(500.0, total);

    }
}
