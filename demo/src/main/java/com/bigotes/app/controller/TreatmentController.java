package com.bigotes.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bigotes.app.model.Treatment;
import com.bigotes.app.service.TreatmentService;

@RestController
@RequestMapping("/treatment")
@CrossOrigin(origins = "http://localhost:4200")
public class TreatmentController {

    @Autowired
    TreatmentService treatmentService;

    // http://localhost:8090/treatment
    @GetMapping()
    public List<Treatment> showAllTreatments() {
        return treatmentService.findAll();
    }

    // http://localhost:8090/treatment/{id}
    @GetMapping("/{id}")
    public Treatment showTreatment(@PathVariable("id") Long id) {
        return treatmentService.findById(id);
    }

    // http://localhost:8090/treatment/pet/{id}
    @GetMapping("/pet/{id}")
    public List<Treatment> showTreatmentbyPet(@PathVariable("id") Long id) {
        return treatmentService.findByPetId(id);
    }

    // http://localhost:8090/treatment
    @PostMapping()
    public void insertTreatment(@RequestBody Treatment treatment) {
        treatmentService.save(treatment);
    }

    // http://localhost:8090/treatment
    @PutMapping()
    public void updateTreatment(@RequestBody Treatment treatment) {
        treatmentService.save(treatment);
    }

    // http://localhost:8090/treatment/{id}
    @DeleteMapping("/{id}")
    public void deleteTreatment(@PathVariable("id") Long id) {
        treatmentService.deleteById(id);
    }

    // Dashboard No. 01
    // http://localhost:8090/treatment/count
    @GetMapping("/count")
    public Long countTotalTreatmentForCurrentMonth() {
        return treatmentService.countTotalTreatmentForCurrentMonth();
    }
    
}
