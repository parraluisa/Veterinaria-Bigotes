package com.example.demo.repositorio;

import java.util.Collection;

public interface CrudRepository<T> {
     
    public T findById(Integer id);

    public Collection<T> findAll();
}
