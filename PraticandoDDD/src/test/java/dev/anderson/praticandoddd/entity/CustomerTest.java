package dev.anderson.praticandoddd.entity;

import dev.anderson.praticandoddd.entity.AddressValueObject;
import dev.anderson.praticandoddd.entity.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    void givenAInvalidIdWhenCreateThenThrowException() {
        var expectedId = "";
        var expectedName = "Anderson";
        var expectedError = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Customer(expectedId, expectedName);
        });
        Assertions.assertEquals("Id do cliente é obrigatório", expectedError.getMessage());
    }
    @Test
    void givenAInvalidNameWhenCreateThenThrowException() {
        var expectedId = "123";
        var expectedName = "";
        var expectedError = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Customer(expectedId, expectedName);
        });
        Assertions.assertEquals("Nome do cliente é obrigatório", expectedError.getMessage());
    }

    @Test
    void givenAValidNameWhenCallChangeNameThenChangeName() {
        var expectedId = "123";
        var expectedName = "Anderson";
        var customer = new Customer(expectedId, expectedName);
        var newName = "Anderson Conforto";
        customer.changeName(newName);
        Assertions.assertEquals(newName, customer.getName());
    }

    @Test
    void givenAValidCustomerAndAddressWhenCallsActivateThenActivate() {
        var expectedId = "123";
        var expectedName = "Anderson";
        var customer = new Customer(expectedId, expectedName);

        Assertions.assertFalse(customer.isActive());

        var expectedStreet = "Rua 1";
        var expectedNumber = "123";
        var expectedCity = "São Paulo";
        var expectedZipCode = "12345678";
        var expectedAddress = new AddressValueObject(expectedStreet, expectedNumber, expectedCity, expectedZipCode);

        customer.setAddress(expectedAddress);

        customer.activate();
        Assertions.assertTrue(customer.isActive());
    }

    @Test
    void givenAValidCustomerAndInvalidAddressWhenCallsActivateThenActivate() {
        var expectedId = "123";
        var expectedName = "Anderson";
        var customer = new Customer(expectedId, expectedName);

        Assertions.assertFalse(customer.isActive());
        var expectedError = Assertions.assertThrows(IllegalArgumentException.class, customer::activate);
        Assertions.assertEquals("Endereço do cliente é obrigatório", expectedError.getMessage());

    }


    @Test
    void givenAValidCustomerAndAddressWhenCallsDeactivateThenDeactivate() {
        var expectedId = "123";
        var expectedName = "Anderson";
        var customer = new Customer(expectedId, expectedName);

        Assertions.assertFalse(customer.isActive());

        var expectedStreet = "Rua 1";
        var expectedNumber = "123";
        var expectedCity = "São Paulo";
        var expectedZipCode = "12345678";
        var expectedAddress = new AddressValueObject(expectedStreet, expectedNumber, expectedCity, expectedZipCode);

        customer.setAddress(expectedAddress);

        customer.activate();
        Assertions.assertTrue(customer.isActive());

        customer.deactivate();
        Assertions.assertFalse(customer.isActive());
    }
}
