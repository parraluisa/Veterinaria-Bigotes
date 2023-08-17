package com.example.demo.servicio;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidad.Pet;
import com.example.demo.repositorio.PetRepository;

@Service
public class PetService implements CrudService<Pet> {

    @Autowired
    private PetRepository petRepository;


    @Override
    public Pet SearchById(int id) {
       return petRepository.findById(id);
    }

    @Override
    public Collection<Pet> SearchAll() {
        return petRepository.findAll();
    }
    
}
