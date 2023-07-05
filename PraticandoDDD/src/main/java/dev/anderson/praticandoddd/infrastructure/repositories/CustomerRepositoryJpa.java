package dev.anderson.praticandoddd.infrastructure.repositories;

import dev.anderson.praticandoddd.infrastructure.db.model.CustomerModel;
import dev.anderson.praticandoddd.infrastructure.db.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepositoryJpa extends JpaRepository<CustomerModel,String> {
}
