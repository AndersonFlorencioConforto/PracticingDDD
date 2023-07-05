package dev.anderson.praticandoddd.infrastructure.repositories;

import dev.anderson.praticandoddd.domain.entity.Customer;
import dev.anderson.praticandoddd.domain.entity.Product;
import dev.anderson.praticandoddd.domain.repositories.CustomerGateway;
import dev.anderson.praticandoddd.domain.repositories.ProductGateway;
import dev.anderson.praticandoddd.infrastructure.db.model.CustomerModel;
import dev.anderson.praticandoddd.infrastructure.db.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerRepositoryGateway implements CustomerGateway {

    @Autowired
    private CustomerRepositoryJpa repository;


    @Override
    public void create(Customer entity) {
        repository.save(CustomerModel.from(entity));
    }

    @Override
    public void update(Customer entity) {
        repository.save(CustomerModel.from(entity));
    }

    @Override
    public Customer findById(String id) {
        return repository.findById(id).map(CustomerModel::toAggregate).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    @Override
    public List<Customer> findAll() {
       return repository.findAll().stream().map(CustomerModel::toAggregate).toList();
    }
}
