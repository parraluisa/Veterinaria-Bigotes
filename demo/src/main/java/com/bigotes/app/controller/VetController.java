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

import com.bigotes.app.model.Pet;
import com.bigotes.app.model.Veterinarian;
import com.bigotes.app.service.VeterinarianService;

@RestController
@RequestMapping("/vet")
@CrossOrigin(origins = "http://localhost:4200")
public class VetController {

    @Autowired
    private VeterinarianService veterinarianService;

    // http://localhost:8090/vet
    @GetMapping()
    public List<Veterinarian> showAllVets(){
        return veterinarianService.findAll();
    }

    // http://localhost:8090/vet/{vetId}
    @GetMapping("/{id}")
    public Veterinarian showPet(@PathVariable("id") Long id) {
        return veterinarianService.findById(id);
    }

    // http://localhost:8090/vet
    @PostMapping()
    public void insertVet(@RequestBody Veterinarian vet) {
        veterinarianService.save(vet);
    }

    // http://localhost:8090/pet
    @PutMapping()
    public void updatePet(@RequestBody Veterinarian vet) {
        veterinarianService.save(vet);
    }

    // http://localhost:8090/pet/{petId}
    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable("id") Long id) {
        veterinarianService.deleteById(id);
    }
}
