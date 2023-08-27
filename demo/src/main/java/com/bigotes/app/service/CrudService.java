package com.bigotes.app.service;

import java.util.Collection;

public interface CrudService<T> {
    T findById(Integer id);
    Collection<T> findAll();
    void deleteById(Integer id);
    void save(T t);
}
