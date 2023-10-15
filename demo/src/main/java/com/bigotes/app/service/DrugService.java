package com.bigotes.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.bigotes.app.model.Drug;
import com.bigotes.app.repository.DrugRepository;

public class DrugService implements CrudService<Drug, Long> {

    @Autowired
    private DrugRepository repository;

    @Override
    public Drug findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Drug> findAll() {
        return Optional.of(repository.findAll()).get();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void save(Drug drug) {
        repository.save(drug);
    }
}
