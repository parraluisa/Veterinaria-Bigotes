package com.bigotes.app.controller;

import com.bigotes.app.model.Pet;
import com.bigotes.app.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
@CrossOrigin(origins = "http://localhost:4200")
public class PetController {

    @Autowired
    private PetService petService;

    // Obtener todas las mascotas
    @GetMapping()
    public ResponseEntity<List<Pet>> showAllPets() {
        List<Pet> pets = petService.findAll();
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    // Obtener una mascota por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Pet> showPet(@PathVariable("id") Long id) {
        Pet pet = petService.findById(id);
        if (pet != null) {
            return new ResponseEntity<>(pet, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Insertar una nueva mascota
    @PostMapping()
    public ResponseEntity<Void> insertPet(@RequestBody Pet pet) {
        petService.save(pet);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Actualizar una mascota
    @PutMapping()
    public ResponseEntity<Void> updatePet(@RequestBody Pet pet) {
        if (petService.findById(pet.getId()) != null) {
            petService.save(pet);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar una mascota por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable("id") Long id) {
        if (petService.findById(id) != null) {
            petService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Obtener las mascotas de un propietario por su ID
    @GetMapping("/owner/{id}")
    public ResponseEntity<List<Pet>> showOwnerPet(@PathVariable("id") Long id) {
        List<Pet> pets = petService.findByOwnerId(id);
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    // Dashboard No. 05
    // Cantidad total de mascotas en la veterinaria
    @GetMapping("/count/total")
    public ResponseEntity<Long> countTotalPets() {
        Long count = petService.countTotalPets();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    // Dashboard No. 06
    // Cantidad de mascotas activas (en tratamiento) en la veterinaria
    @GetMapping("/count/ontreatment")
    public ResponseEntity<Long> countActivePets() {
        Long count = petService.countActivePets();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
}
