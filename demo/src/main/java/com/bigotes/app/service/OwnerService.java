package com.bigotes.app.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigotes.app.model.Owner;
import com.bigotes.app.repository.CrudRepository;

@Service
public class OwnerService implements CrudService<Owner> {
    
    @Autowired
    private CrudRepository<Owner> repository;

    @Override
    public Owner findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Collection<Owner> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void save(Owner Owner) {
        repository.save(Owner);
    }
}
