package com.bigotes.app.repository;

import com.bigotes.app.model.Owner;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class OwnerRepository implements CrudRepository<Owner>{
    private Map<Integer, Owner> data = new HashMap<>();

    public OwnerRepository() {
        insertSampleData();
    }

    public void insertSampleData() {
        data.put(1, new Owner(1, 1342, "Juan", "Perez", "Montoya", "12345678", "juan@gmail.com"));
        data.put(2, new Owner(2, 8543, "Camilo", "García", "Parra", "23456789", "camilo@gmail.com"));
    }

    @Override
    public Owner findById(Integer id) {
        return data.get(id);
    }

    @Override
    public Collection<Owner> findAll() {
        return data.values();
    }

    @Override
    public void deleteById(Integer id) {
        data.remove(id);
    }

    @Override
    public void save(Owner Owner) {
        if (Owner.getId() != null && data.containsKey(Owner.getId())) {
            data.put(Owner.getId(), Owner);
        } else {
            int tam = data.size();
            int lastId = data.get(tam).getId();
            Owner.setId(lastId + 1);
            data.put(Owner.getId(), Owner);
        }
    }

    public Owner findByIdCard(Integer idCard) {
        for (Owner owner : data.values()) {
            if (owner.getIdCard().equals(idCard)) {
                return owner;
            }
        }
        return null;
    }
}
