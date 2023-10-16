package com.bigotes.app.service;

import com.bigotes.app.model.Pet;
import com.bigotes.app.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService implements CrudService<Pet, Long> {

    @Autowired
    private PetRepository repository;

    @Override
    public Pet findById(Long id) {
       return repository.findById(id).orElse(null);
    }

    @Override
    public List<Pet> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void save(Pet pet) {
        repository.save(pet);
    }

    public List<Pet> findByOwnerId(Long ownerId) {
        return repository.findByOwnerId(ownerId);
    }

    // Dashboard No. 05
    // Cantidad de mascotas totales en la veterinaria
    public Long countTotalPets(){
        return repository.countTotalPets();
    }

    // Dashboard No. 06
    // Cantidad de mascotas activas (en tratamiento) en la veterinaria
    public Long countActivePets(){
        return repository.countActivePets();
    }
}
