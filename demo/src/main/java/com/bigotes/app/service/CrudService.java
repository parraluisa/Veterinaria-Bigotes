package com.bigotes.app.service;

import java.util.List;

public interface CrudService<T, ID> {
    T findById(ID id);
    List<T> findAll();
    void deleteById(ID id);
    void save(T t);
}