package com.bigotes.app.service;

import com.bigotes.app.model.Veterinarian;
import com.bigotes.app.repository.VeterinarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeterinarianService implements CrudService<Veterinarian, Long>{

    @Autowired
    private VeterinarianRepository repository;

    @Override
    public Veterinarian findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Veterinarian> findAll() {
        return Optional.of(repository.findAll()).get();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void save(Veterinarian Veterinarian) {
        repository.save(Veterinarian);
    }

    public Veterinarian findByIdCard(Long idCard) {
        return repository.findByIdCard(idCard);
    }

    public boolean existsByIdCard(Long idCard) {
        return repository.existsByIdCard(idCard);
    }
}
