package com.modasby.testetecnico.repository;

import java.util.List;

public interface Repository<T> {
    void save(T t);
    T findById(Long id);
    List<T> findAll();
    void delete(T obj);
    T update(T t);
}
