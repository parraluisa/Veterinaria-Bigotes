package com.bigotes.app.service;

import com.bigotes.app.model.Drug;
import com.bigotes.app.repository.DrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Drug save(Drug drug) {
        return repository.save(drug);
    }

    public List<Drug> findDrugsAvailabale() {
        return repository.findDrugsAvailabale();
    }

    // Dashboard No. 02
    // Cantidad de tratamientos por tipo de medicamento administrado 
    // en el último mes (tabla medicamento - cantidad)
    public List<Object[]> countTreatmentsByDrugTypeLastMonth(){
        return repository.countTreatmentsByDrugTypeLastMonth();
    }

    // Dashboard No. 07
    // Ventas totales de la veterinaria
    public Float calculateTotalSales(){
        return repository.calculateTotalSales();
    } 

    // Dashboard No. 08
    // Ganancias totales de la veterinaria
    public Float calculateTotalProfits(){
        return repository.calculateTotalProfits();
    }

    // Dashboard No. 09
    // Top 3 medicamentos con más unidades vendidas
    public List<Drug> findTop3BestSellingDrugs() {
        List<Object[]> results = repository.findTop3BestSellingDrugs();
        List<Drug> top3Drugs = new ArrayList<>();

        for (Object[] result : results) {
            Drug drug = (Drug) result[0];
            top3Drugs.add(drug);
        }
        return top3Drugs;
    }
}
