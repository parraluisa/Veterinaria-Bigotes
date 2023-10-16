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

import com.bigotes.app.model.Drug;
import com.bigotes.app.service.DrugService;

@RestController
@RequestMapping("/drug")
@CrossOrigin(origins = "http://localhost:4200")
public class DrugController {
    
    @Autowired
    DrugService drugService;

    // http://localhost:8090/drug
    @GetMapping()
    public List<Drug> showAllDrugs() {
        return drugService.findAll();
    }

    // http://localhost:8090/drug/{id}
    @GetMapping("/{id}")
    public Drug showDrug(@PathVariable("id") Long id) {
        return drugService.findById(id);
    }

    // http://localhost:8090/drug
    @PostMapping()
    public void insertDrug(@RequestBody Drug drug) {
        drugService.save(drug);
    }

    // http://localhost:8090/drug
    @PutMapping()
    public void updateDrug(@RequestBody Drug drug) {
        drugService.save(drug);
    }

    // http://localhost:8090/drug/{id}
    @DeleteMapping("/{id}")
    public void deleteDrug(@PathVariable("id") Long id) {
        drugService.deleteById(id);
    }

    // Dashboard No. 02
    @GetMapping("/treatmentbymonth")
    public List<Object[]> countTreatmentsByDrugTypeLastMonth() {
        return drugService.countTreatmentsByDrugTypeLastMonth();
    }


}
