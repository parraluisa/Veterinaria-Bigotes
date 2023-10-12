package com.bigotes.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
