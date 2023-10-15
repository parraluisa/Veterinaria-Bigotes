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

    // http://localhost:8090/drug
    @GetMapping()
    public List<Treatment> showAllDrugs() {
        return treatmentService.findAll();
    }

    // http://localhost:8090/drug/{id}
    @GetMapping("/{id}")
    public Treatment showDrug(@PathVariable("id") Long id) {
        return treatmentService.findById(id);
    }

    // http://localhost:8090/drug
    @PostMapping()
    public void insertDrug(@RequestBody Treatment treatment) {
        treatmentService.save(treatment);
    }

    // http://localhost:8090/drug
    @PutMapping()
    public void updateDrug(@RequestBody Treatment treatment) {
        treatmentService.save(treatment);
    }

    // http://localhost:8090/drug/{id}
    @DeleteMapping("/{id}")
    public void deleteDrug(@PathVariable("id") Long id) {
        treatmentService.deleteById(id);
    }
    
}
