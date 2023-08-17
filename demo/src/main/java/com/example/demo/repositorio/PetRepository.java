package com.example.demo.repositorio;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import com.example.demo.entidad.Pet;

@Repository
public class PetRepository implements CrudRepository<Pet>{
    private Map<Integer, Pet> data = new HashMap<>();

    public PetRepository() {
        insertSampleData();
    }

    public void insertSampleData() {
        data.put(1, new Pet("Firulais", "Pitbull", 3, "Rabia", LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 1)));
        data.put(2,
                new Pet("Peter", "Collie", 4, "Dolor de estomago", LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 1)));
        data.put(3, new Pet("Miguel", "Pug", 5, "Dolor de cabeza", LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 1)));
        data.put(4, new Pet("Mariano", "Pitbull", 6, "Dolor de garganta", LocalDate.of(2020, 1, 1),
                LocalDate.of(2020, 1, 1)));
    }
    
    @Override
    public Pet findById(Integer id) {
        return data.get(id);
    }

    @Override
    public Collection<Pet> findAll() {
        return data.values();
    }
}
