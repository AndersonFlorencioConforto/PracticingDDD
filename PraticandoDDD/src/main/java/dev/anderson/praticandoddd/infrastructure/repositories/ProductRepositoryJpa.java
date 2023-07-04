package dev.anderson.praticandoddd.infrastructure.repositories;

import dev.anderson.praticandoddd.infrastructure.db.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositoryJpa extends JpaRepository<ProductModel,String> {
}
