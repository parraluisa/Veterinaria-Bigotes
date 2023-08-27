package com.bigotes.app.repository;

import java.util.Collection;

public interface CrudRepository<T> {
     
    T findById(Integer id);
    Collection<T> findAll();
    void deleteById(Integer id);
    void save(T t);
}
