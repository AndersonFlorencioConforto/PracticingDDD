package dev.anderson.praticandoddd.service;

import dev.anderson.praticandoddd.entity.Customer;
import dev.anderson.praticandoddd.entity.Order;
import dev.anderson.praticandoddd.entity.OrderItem;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class OrderService {

    public static Double total (Order... orders) {
        return Arrays.stream(orders)
                .mapToDouble(Order::total)
                .sum();

    }

    public static Order placeOrder(Customer customer, List<OrderItem> items) {
        var order = new Order(UUID.randomUUID().toString(), customer.getId(), items);
        customer.addRewards(order.total() / 2);
        return order;
    }
}
