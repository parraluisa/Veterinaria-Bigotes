package com.bigotes.app.controller;

import com.bigotes.app.model.Veterinarian;
import com.bigotes.app.service.VeterinarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vet")
@CrossOrigin(origins = "http://localhost:4200")
public class VetController {

    @Autowired
    private VeterinarianService veterinarianService;

    // Obtener todos los veterinarios
    @GetMapping()
    public ResponseEntity<List<Veterinarian>> showAllVets() {
        List<Veterinarian> vets = veterinarianService.findAll();
        return new ResponseEntity<>(vets, HttpStatus.OK);
    }

    // Obtener un veterinario por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Veterinarian> showVet(@PathVariable("id") Long id) {
        Veterinarian vet = veterinarianService.findById(id);
        if (vet != null) {
            return new ResponseEntity<>(vet, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Obtener un veterinario por su número de identificación (ID Card)
    @GetMapping("/idcard/{id}")
    public ResponseEntity<Veterinarian> showVetByIdCard(@PathVariable("id") Long id) {
        Veterinarian vet = veterinarianService.findByIdCard(id);
        if (vet != null) {
            return new ResponseEntity<>(vet, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Insertar un nuevo veterinario
    @PostMapping()
    public ResponseEntity<Void> insertVet(@RequestBody Veterinarian vet) {
        veterinarianService.save(vet);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Actualizar un veterinario
    @PutMapping()
    public ResponseEntity<Void> updateVet(@RequestBody Veterinarian vet) {
        if (veterinarianService.findById(vet.getId()) != null) {
            veterinarianService.save(vet);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un veterinario por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVet(@PathVariable("id") Long id) {
        if (veterinarianService.findById(id) != null) {
            veterinarianService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Verificar si un veterinario existe por número de identificación (ID Card)
    @GetMapping("/exists/{idCard}")
    public ResponseEntity<Boolean> vetExists(@PathVariable("idCard") Long idCard) {
        boolean exists = veterinarianService.existsByIdCard(idCard);
        return new ResponseEntity<>(exists, HttpStatus.OK);
    }

    // Dashboard No. 03
    // Cantidad de veterinarios activos en la plataforma
    @GetMapping("/count/active")
    public ResponseEntity<Long> countActiveVeterinarians() {
        Long count = veterinarianService.countActiveVeterinarians();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    // Dashboard No. 04
    // Cantidad de veterinarios inactivos en la plataforma
    @GetMapping("/count/inactive")
    public ResponseEntity<Long> countInactiveVeterinarians() {
        Long count = veterinarianService.countInactiveVeterinarians();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
}
