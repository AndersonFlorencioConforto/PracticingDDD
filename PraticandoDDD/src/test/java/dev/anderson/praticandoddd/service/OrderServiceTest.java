package dev.anderson.praticandoddd.service;

import dev.anderson.praticandoddd.domain.entity.Customer;
import dev.anderson.praticandoddd.domain.entity.Order;
import dev.anderson.praticandoddd.domain.entity.OrderItem;
import dev.anderson.praticandoddd.domain.service.OrderService;
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

        Order[] orderArray = {order, order2};
        var total = OrderService.total(orderArray);
        Assertions.assertEquals(500.0, total);

    }

    @Test
    void givenAValidCommandWhenCreateOrderShouldAddRewardsCustomer() {

        var customer = new Customer("123", "Anderson");
        var item1 = new OrderItem("123", "item 1", 100.00, "123", 3);
        var order = OrderService.placeOrder(customer, List.of(item1));

        Assertions.assertEquals(150, customer.getRewards());
        Assertions.assertEquals(300.0, order.total());
    }
}
