package com.bigotes.app.controller;

import com.bigotes.app.model.Treatment;
import com.bigotes.app.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/treatment")
@CrossOrigin(origins = "http://localhost:4200")
public class TreatmentController {

    @Autowired
    TreatmentService treatmentService;

    // Obtener todos los tratamientos
    @GetMapping()
    public ResponseEntity<List<Treatment>> showAllTreatments() {
        List<Treatment> treatments = treatmentService.findAll();
        return new ResponseEntity<>(treatments, HttpStatus.OK);
    }

    // Obtener un tratamiento por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Treatment> showTreatment(@PathVariable("id") Long id) {
        Treatment treatment = treatmentService.findById(id);
        if (treatment != null) {
            return new ResponseEntity<>(treatment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Obtener tratamientos para una mascota por su ID
    @GetMapping("/pet/{id}")
    public ResponseEntity<List<Treatment>> showTreatmentbyPet(@PathVariable("id") Long id) {
        List<Treatment> treatments = treatmentService.findByPetId(id);
        return new ResponseEntity<>(treatments, HttpStatus.OK);
    }

    // Insertar un nuevo tratamiento
    @PostMapping()
    public ResponseEntity<Treatment> insertTreatment(@RequestBody Treatment treatment) {
        Treatment savedTreatment = treatmentService.save(treatment);
        return new ResponseEntity<>(savedTreatment, HttpStatus.CREATED);
    }

    // Actualizar un tratamiento
    @PutMapping()
    public ResponseEntity<Void> updateTreatment(@RequestBody Treatment treatment) {
        if (treatmentService.findById(treatment.getId()) != null) {
            treatmentService.save(treatment);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un tratamiento por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTreatment(@PathVariable("id") Long id) {
        if (treatmentService.findById(id) != null) {
            treatmentService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Dashboard No. 01
    // Cantidad total de tratamientos administrados en el último mes
    @GetMapping("/count")
    public ResponseEntity<Long> countTotalTreatmentForCurrentMonth() {
        Long count = treatmentService.countTotalTreatmentForCurrentMonth();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
}
