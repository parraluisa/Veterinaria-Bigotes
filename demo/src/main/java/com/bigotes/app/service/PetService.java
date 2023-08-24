package com.bigotes.app.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigotes.app.model.Pet;
import com.bigotes.app.repository.CrudRepository;

@Service
public class PetService implements CrudService<Pet> {

    @Autowired
    private CrudRepository<Pet> repository;


    @Override
    public Pet findById(Integer id) {
       return repository.findById(id);
    }

    @Override
    public Collection<Pet> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void save(Pet pet) {
        repository.save(pet);
    }
}
