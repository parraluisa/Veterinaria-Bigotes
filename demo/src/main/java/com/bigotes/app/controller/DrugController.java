package com.bigotes.app.controller;

import com.bigotes.app.model.Drug;
import com.bigotes.app.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drug")
@CrossOrigin(origins = "http://localhost:4200")
public class DrugController {
    
    @Autowired
    DrugService drugService;

    // http://localhost:8090/drug
    
    @GetMapping()
    public ResponseEntity<List<Drug>> showAllDrugs() {
        List<Drug> drugs =  drugService.findAll();
        return new ResponseEntity<List<Drug>>(drugs, HttpStatus.OK);
    }

    // http://localhost:8090/drug/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Drug> showDrug(@PathVariable("id") Long id) {
        Drug drug = drugService.findById(id);
        if (drug == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Drug>(drug, HttpStatus.OK);
    }

    // http://localhost:8090/drug
    @PostMapping()
    public ResponseEntity<Drug> insertDrug(@RequestBody Drug drug) {
        Drug newDrug = drugService.save(drug);
        if (newDrug == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Drug>(newDrug, HttpStatus.CREATED);
    }

    // http://localhost:8090/drug
    @PutMapping()
    public ResponseEntity<Drug> updateDrug(@RequestBody Drug drug) {
        Drug newDrug = drugService.save(drug);
        return new ResponseEntity<Drug>(newDrug, HttpStatus.OK);
    }

    // http://localhost:8090/drug/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDrug(@PathVariable("id") Long id) {
        drugService.deleteById(id);
        return new ResponseEntity<String>("Drug deleted", HttpStatus.OK);
    }

    // http://localhost:8090/drug/available
    @GetMapping("/available")
    public ResponseEntity<List<Drug>> findDrugsAvailable() {
        List<Drug> drugs = drugService.findDrugsAvailabale();
        return new ResponseEntity<List<Drug>>(drugs, HttpStatus.OK);
    }

    // Dashboard No. 02
    // Cantidad de tratamientos por tipo de medicamento administrado 
    // en el último mes (tabla medicamento - cantidad)
    // http://localhost:8090/drug/treatmentbymonth
    @GetMapping("/treatmentbymonth")
    public ResponseEntity<List<Object[]>> countTreatmentsByDrugTypeLastMonth() {
        List<Object[]> drugs = drugService.countTreatmentsByDrugTypeLastMonth();
        return new ResponseEntity<List<Object[]>>(drugs, HttpStatus.OK);
    }

    // Dashboard No. 07
    // Ventas totales de la veterinaria
    // http://localhost:8090/drug/totalsales
    @GetMapping("/totalsales")
    public ResponseEntity<Float> calculateTotalSales() {
        Float totalSales = drugService.calculateTotalSales();
        return new ResponseEntity<Float>(totalSales, HttpStatus.OK);
    }

    // Dashboard No. 08
    // Ganancias totales de la veterinaria
    // http://localhost:8090/drug/totalprofits
    @GetMapping("/totalprofits")
    public ResponseEntity<Float> calculateTotalProfits(){
        Float totalProfits = drugService.calculateTotalProfits();
        return new ResponseEntity<Float>(totalProfits, HttpStatus.OK);
    }

    // Dashboard No. 08
    // Ganancias totales de la veterinaria
    // http://localhost:8090/drug/top
    @GetMapping("/top")
    public ResponseEntity<List<Drug>> findTop3BestSellingDrugs(){
        List<Drug> drugs = drugService.findTop3BestSellingDrugs();
        return new ResponseEntity<List<Drug>>(drugs, HttpStatus.OK);
    }


}
