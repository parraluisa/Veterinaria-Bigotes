package com.bigotes.app.service;

import java.util.Collection;

public interface CrudService<T, ID> {
    T findById(ID id);
    Collection<T> findAll();
    void deleteById(ID id);
    void save(T t);
}