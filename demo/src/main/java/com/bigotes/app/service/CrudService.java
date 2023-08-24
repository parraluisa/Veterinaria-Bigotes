package com.bigotes.app.service;

import java.util.Collection;

public interface CrudService<T> {
    public T findById(Integer id);

    public Collection<T> findAll();

    public void deleteById(Integer id);

    public void save(T t);
}
