package com.bigotes.app.service;

import com.bigotes.app.model.Owner;
import com.bigotes.app.model.Pet;
import com.bigotes.app.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService implements CrudService<Owner, Long> {
    
    @Autowired
    private OwnerRepository repository;

    @Autowired
    private PetService petService;

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
        for (Pet pet : petService.findByOwnerId(id)) {
            petService.deleteById(pet.getId());
        }
        repository.deleteById(id);
    }

    @Override
    public Owner save(Owner Owner) {
        return repository.save(Owner);
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

    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }

    public boolean existsByPhone(String phone) {
        return repository.existsByPhone(phone);
    }
}
