package com.bigotes.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigotes.app.model.Treatment;
import com.bigotes.app.repository.TreatmentRepository;

@Service
public class TreatmentService implements CrudService<Treatment, Long> {


    @Autowired
    private TreatmentRepository repository;

    @Override
    public Treatment findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Treatment> findAll() {
        return Optional.of(repository.findAll()).get();
    }

    public List<Treatment> findByPetId(Long petId) {
        return Optional.of(repository.findByPetId(petId)).get();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Treatment save(Treatment treatment) {
        if (treatment.getDrug().getItemsAvailable()<=0){
            return null;
        }
        else{
            return repository.save(treatment);
        }
    }

    // Dashboard No. 01
    // Cantidad total de tratamiento administrados en el último mes
    public Long countTotalTreatmentForCurrentMonth(){
        return repository.countTotalTreatmentForCurrentMonth();
    }
}
