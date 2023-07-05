package dev.anderson.praticandoddd.infrastructure.repositories;

import dev.anderson.praticandoddd.domain.entity.AddressValueObject;
import dev.anderson.praticandoddd.domain.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryGatewayTest {

    @Autowired
    private CustomerRepositoryGateway customerRepositoryGateway;
    @Autowired
    private CustomerRepositoryJpa customerRepositoryJpa;

    @Test
    void create() {
        final var expectedCustomer = new Customer("1", "Anderson");
        final var expectedAddress = new AddressValueObject("Rua 1", "123", "São Paulo", "12345678");
        expectedCustomer.setAddress(expectedAddress);
        customerRepositoryGateway.create(expectedCustomer);
        final var actualCustomer = customerRepositoryJpa.findById("1").get();
        assertEquals(expectedCustomer.getId(), actualCustomer.getId());
        assertEquals(expectedCustomer.getName(), actualCustomer.getName());
    }

    @Test
    void update() {
        final var expectedCustomer = new Customer("1", "Anderson");
        final var expectedAddress = new AddressValueObject("Rua 1", "123", "São Paulo", "12345678");
        expectedCustomer.setAddress(expectedAddress);
        customerRepositoryGateway.create(expectedCustomer);
        final var actualCustomer = customerRepositoryJpa.findById("1").get();
        assertEquals(expectedCustomer.getId(), actualCustomer.getId());
        assertEquals(expectedCustomer.getName(), actualCustomer.getName());
        assertEquals(expectedCustomer.isActive(), actualCustomer.isActive());

        expectedCustomer.activate();
        expectedCustomer.changeName("Conforto");
        customerRepositoryGateway.update(expectedCustomer);
        final var actualCustomerUpdated = customerRepositoryJpa.findById("1").get();
        assertEquals(expectedCustomer.getId(), actualCustomerUpdated.getId());
        assertEquals(expectedCustomer.getName(), actualCustomerUpdated.getName());
        assertEquals(expectedCustomer.isActive(), actualCustomerUpdated.isActive());
    }

    @Test
    void findById() {
        final var expectedCustomer = new Customer("1", "Anderson");
        final var expectedAddress = new AddressValueObject("Rua 1", "123", "São Paulo", "12345678");
        expectedCustomer.setAddress(expectedAddress);
        customerRepositoryGateway.create(expectedCustomer);
        final var actualCustomer = customerRepositoryGateway.findById("1");
        assertEquals(expectedCustomer.getId(), actualCustomer.getId());
        assertEquals(expectedCustomer.getName(), actualCustomer.getName());
    }

    @Test
    void findAll() {
        final var expectedCustomer1 = new Customer("1", "Anderson");
        final var expectedAddress1 = new AddressValueObject("Rua 1", "123", "São Paulo", "12345678");
        expectedCustomer1.setAddress(expectedAddress1);
        customerRepositoryGateway.create(expectedCustomer1);

        final var expectedCustomer2 = new Customer("2", "Conforto");
        final var expectedAddress2 = new AddressValueObject("Rua 2", "456", "São Paulo", "12345678");
        expectedCustomer2.setAddress(expectedAddress2);
        customerRepositoryGateway.create(expectedCustomer2);

        final var actualCustomers = customerRepositoryGateway.findAll();
        assertEquals(2, actualCustomers.size());
    }

    @Test
    void givenInvalidIdWhenFindByIdThenThrow() {
        final var expectedError = assertThrows(RuntimeException.class, () -> customerRepositoryGateway.findById("1asd"));
        assertEquals("Customer not found", expectedError.getMessage());
    }
}