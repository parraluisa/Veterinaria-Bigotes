package com.bigotes.app.controller;

import com.bigotes.app.model.Veterinarian;
import com.bigotes.app.service.VeterinarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return veterinarianService.findByIdCard(id);
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

    // http://localhost:8090/vet/exists/{vetId}
    @GetMapping("/exists/{idCard}")
    public boolean vetExists(@PathVariable("idCard") Long idCard) {
        return veterinarianService.existsByIdCard(idCard);
    }

    // Dashboard No. 03
    // Cantidad de veterinarios activos en la plataforma
    // http://localhost:8090/vet/count/active
    @GetMapping("/count/active")
    public Long countActiveVeterinarians(){
        return veterinarianService.countActiveVeterinarians();
    }

    // Dashboard No. 04
    //Cantidad de veterinarios inactivos en la plataforma
    // http://localhost:8090/vet/count/inactive
    @GetMapping("/count/inactive")
    public Long countInactiveVeterinarians(){
        return veterinarianService.countInactiveVeterinarians();
    }
}
