package dev.anderson.praticandoddd.domain.repositories;

import java.util.List;

public interface RepositoryGateway<T> {

        void create(T entity);
        void update(T entity);
        T findById(String id);
        List<T> findAll();
}
