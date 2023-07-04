package dev.anderson.praticandoddd;

import dev.anderson.praticandoddd.domain.entity.AddressValueObject;
import dev.anderson.praticandoddd.domain.entity.Customer;
import dev.anderson.praticandoddd.domain.entity.Order;
import dev.anderson.praticandoddd.domain.entity.OrderItem;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var customer = new Customer("123", "Anderson");
        var address = new AddressValueObject("Rua teste", "74", "São Paulo", "123456");
        customer.setAddress(address);
        customer.activate();

        var item1 = new OrderItem("1", "Item 1", 10.0, "1", 1);
        var item2 = new OrderItem("2", "Item 2", 20.0, "2", 2);
        var item3 = new OrderItem("3", "Item 3", 30.0, "3", 3);

        var order = new Order("1", "123", List.of(item1, item2, item3));

        System.out.println(customer.toString());
        System.out.println(order.toString());
        System.out.println(order.total());

    }
}
