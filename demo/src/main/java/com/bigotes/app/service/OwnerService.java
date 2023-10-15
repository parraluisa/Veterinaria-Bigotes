package com.bigotes.app.service;

import com.bigotes.app.model.Owner;
import com.bigotes.app.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService implements CrudService<Owner, Long> {
    
    @Autowired
    private OwnerRepository repository;

    @Override
    public Owner findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Owner> findAll() {
        return Optional.of(repository.findAll()).get();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void save(Owner Owner) {
        repository.save(Owner);
    }

    public Owner findByIdCard(Long idCard) {
        return repository.findByIdCard(idCard);
    }

    public Owner findOwnerByPetId(Long id) {
        return repository.findOwnerByPets_Id(id);
    }

    public boolean existsByIdCard(Long idCard) {
        return repository.existsByIdCard(idCard);
    }
}
