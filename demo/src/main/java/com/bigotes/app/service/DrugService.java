package com.bigotes.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigotes.app.model.Drug;
import com.bigotes.app.repository.DrugRepository;

@Service
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

    // Dashboard No. 02
    // Cantidad de tratamientos por tipo de medicamento administrado 
    // en el último mes (tabla medicamento - cantidad)
    public List<Object[]> countTreatmentsByDrugTypeLastMonth(){
        return repository.countTreatmentsByDrugTypeLastMonth();
    }

    // Dashboard No. 08
    public Float calculateTotalSales(){
        return repository.calculateTotalSales();
    } 

    // Dashboard No. 09
    public Float calculateTotalProfits(){
        return repository.calculateTotalProfits();
    } 
}
