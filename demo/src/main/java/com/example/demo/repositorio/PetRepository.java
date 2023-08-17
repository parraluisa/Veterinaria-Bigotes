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
        data.put(1, new Pet("https://ca-times.brightspotcdn.com/dims4/default/c3f4b96/2147483647/strip/true/crop/1970x1108+39+0/resize/1200x675!/quality/80/?url=https%3A%2F%2Fcalifornia-times-brightspot.s3.amazonaws.com%2F12%2Fa5%2F79e097ccf62312d18a025f22ce48%2Fhoyla-recuento-11-cosas-aman-gatos-top-001","Firulais", "Persa", 3, 13.2, "Rabia", LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 1)));
        data.put(2,
                new Pet("https://ca-times.brightspotcdn.com/dims4/default/c3f4b96/2147483647/strip/true/crop/1970x1108+39+0/resize/1200x675!/quality/80/?url=https%3A%2F%2Fcalifornia-times-brightspot.s3.amazonaws.com%2F12%2Fa5%2F79e097ccf62312d18a025f22ce48%2Fhoyla-recuento-11-cosas-aman-gatos-top-001","Peter", "Himalaya", 4, 14.2, "Dolor de estomago", LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 1)));
        data.put(3, new Pet("https://ca-times.brightspotcdn.com/dims4/default/c3f4b96/2147483647/strip/true/crop/1970x1108+39+0/resize/1200x675!/quality/80/?url=https%3A%2F%2Fcalifornia-times-brightspot.s3.amazonaws.com%2F12%2Fa5%2F79e097ccf62312d18a025f22ce48%2Fhoyla-recuento-11-cosas-aman-gatos-top-001","Miguel", "Pug", 5, 10.2, "Dolor de cabeza", LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 1)));
        data.put(4, new Pet("https://ca-times.brightspotcdn.com/dims4/default/c3f4b96/2147483647/strip/true/crop/1970x1108+39+0/resize/1200x675!/quality/80/?url=https%3A%2F%2Fcalifornia-times-brightspot.s3.amazonaws.com%2F12%2Fa5%2F79e097ccf62312d18a025f22ce48%2Fhoyla-recuento-11-cosas-aman-gatos-top-001","Mariano", "Pitbull", 6, 11.1,"Dolor de garganta", LocalDate.of(2020, 1, 1),
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
