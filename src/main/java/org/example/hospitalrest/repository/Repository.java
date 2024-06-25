package org.example.hospitalrest.repository;

import java.util.List;

public interface Repository<T> {
    T findById(int id);
    List<T> findAll();
    T save(T entity);
    void delete(T entity);
}