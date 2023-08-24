package com.bigotes.app.repository;

import org.springframework.stereotype.Repository;

import com.bigotes.app.model.Pet;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PetRepository implements CrudRepository<Pet>{
    private Map<Integer, Pet> data = new HashMap<>();

    public PetRepository() {
        insertSampleData();
    }

    public void insertSampleData() {
        data.put(0, new Pet(0, "https://ca-times.brightspotcdn.com/dims4/default/c3f4b96/2147483647/strip/true/crop/1970x1108+39+0/resize/1200x675!/quality/80/?url=https%3A%2F%2Fcalifornia-times-brightspot.s3.amazonaws.com%2F12%2Fa5%2F79e097ccf62312d18a025f22ce48%2Fhoyla-recuento-11-cosas-aman-gatos-top-001","Firulais", "Persa", 3, 13.2, "Rabia", LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 1)));
        data.put(1,
                new Pet(1, "https://ca-times.brightspotcdn.com/dims4/default/c3f4b96/2147483647/strip/true/crop/1970x1108+39+0/resize/1200x675!/quality/80/?url=https%3A%2F%2Fcalifornia-times-brightspot.s3.amazonaws.com%2F12%2Fa5%2F79e097ccf62312d18a025f22ce48%2Fhoyla-recuento-11-cosas-aman-gatos-top-001","Peter", "Himalaya", 4, 14.2, "Dolor de estomago", LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 1)));
        data.put(2, new Pet(2, "https://ca-times.brightspotcdn.com/dims4/default/c3f4b96/2147483647/strip/true/crop/1970x1108+39+0/resize/1200x675!/quality/80/?url=https%3A%2F%2Fcalifornia-times-brightspot.s3.amazonaws.com%2F12%2Fa5%2F79e097ccf62312d18a025f22ce48%2Fhoyla-recuento-11-cosas-aman-gatos-top-001","Miguel", "Pug", 5, 10.2, "Dolor de cabeza", LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 1)));
        data.put(3, new Pet(3, "https://ca-times.brightspotcdn.com/dims4/default/c3f4b96/2147483647/strip/true/crop/1970x1108+39+0/resize/1200x675!/quality/80/?url=https%3A%2F%2Fcalifornia-times-brightspot.s3.amazonaws.com%2F12%2Fa5%2F79e097ccf62312d18a025f22ce48%2Fhoyla-recuento-11-cosas-aman-gatos-top-001","Mariano", "Pitbull", 6, 11.1,"Dolor de garganta", LocalDate.of(2020, 1, 1),
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

    @Override
    public void deleteById(Integer id) {
        data.remove(id);
    }

    @Override
    public void save(Pet pet) {
        if (pet.getId() != null && data.containsKey(pet.getId())) {
            data.put(pet.getId(), pet);
        } else {
            int tam = data.size();
            int lastId = data.get(tam).getId();
            pet.setId(lastId + 1);
            data.put(pet.getId(), pet);
        }
    }
}
