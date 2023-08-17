package com.example.demo.servicio;

import java.util.Collection;

public interface CrudService<T> {
    public T SearchById(int id);

    public Collection<T> SearchAll();
}
