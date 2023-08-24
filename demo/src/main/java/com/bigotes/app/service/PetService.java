package com.bigotes.app.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigotes.app.model.Pet;
import com.bigotes.app.repository.CrudRepository;

@Service
public class PetService implements CrudService<Pet> {

    @Autowired
    private CrudRepository<Pet> petRepository;


    @Override
    public Pet findById(Integer id) {
       return petRepository.findById(id);
    }

    @Override
    public Collection<Pet> findAll() {
        return petRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        petRepository.deleteById(id);
    }

    @Override
    public void save(Pet pet) {
        petRepository.save(pet);
    }
}
