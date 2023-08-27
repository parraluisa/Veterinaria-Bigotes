package com.bigotes.app.service;

import com.bigotes.app.model.Owner;
import com.bigotes.app.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class OwnerService implements CrudService<Owner> {
    
    @Autowired
    private OwnerRepository repository;

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

    public Owner findByIdCard(Integer idCard) {
        return repository.findByIdCard(idCard);
    }
}
