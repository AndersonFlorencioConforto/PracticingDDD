package dev.anderson.praticandoddd.service;

import dev.anderson.praticandoddd.entity.Order;

import java.util.Arrays;

public class OrderService {

    public static Double total (Order... orders) {
        return Arrays.stream(orders)
                .mapToDouble(Order::total)
                .sum();

    }
}
