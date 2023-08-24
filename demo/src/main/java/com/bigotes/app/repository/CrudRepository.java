package com.bigotes.app.repository;

import java.util.Collection;

public interface CrudRepository<T> {
     
    public T findById(Integer id);

    public Collection<T> findAll();

    public void deleteById(Integer id);

    public void save(T t);
}
