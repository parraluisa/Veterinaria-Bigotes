package com.bigotes.app.controller;

import com.bigotes.app.DTOs.PetDTO;
import com.bigotes.app.DTOs.PetMapper;
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
    public ResponseEntity<List<PetDTO>> showAllPets() {
        List<Pet> pets = petService.findAll();
        List<PetDTO> petsDTO = PetMapper.INSTANCE.convertList(pets);
        if (pets.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(petsDTO, HttpStatus.OK);
    }

    // Obtener una mascota por su ID
    @GetMapping("/{id}")
    public ResponseEntity<PetDTO> showPet(@PathVariable("id") Long id) {
        Pet pet = petService.findById(id);
        PetDTO petDTO = PetMapper.INSTANCE.convert(pet);
        if (petDTO != null) {
            return new ResponseEntity<>(petDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Insertar una nueva mascota
    @PostMapping()
    public ResponseEntity<PetDTO> insertPet(@RequestBody Pet pet) {
        Pet petCreated = petService.save(pet);
        PetDTO petDTO = PetMapper.INSTANCE.convert(petCreated);
        if (petDTO == null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(petDTO, HttpStatus.CREATED);
    }

    // Actualizar una mascota
    @PutMapping()
    public ResponseEntity<PetDTO> updatePet(@RequestBody Pet pet) {
        if (petService.findById(pet.getId()) != null) {
            Pet petUpdated = petService.save(pet);
            PetDTO petDTO = PetMapper.INSTANCE.convert(petUpdated);
            return new ResponseEntity<>(petDTO, HttpStatus.OK);
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
    public ResponseEntity<List<PetDTO>> showOwnerPet(@PathVariable("id") Long id) {
        List<Pet> pets = petService.findByOwnerIdCard(id);
        List<PetDTO> petsDTO = PetMapper.INSTANCE.convertList(pets);
        if (petsDTO.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(petsDTO, HttpStatus.OK);
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

    // http://localhost:8090/pet/all/ontreatment
    @GetMapping("/all/ontreatment")
    public ResponseEntity<List<PetDTO>> showAllPetsInTreatment() {
        List<Pet> pets = petService.findPetsInTreatment();
        List<PetDTO> petsDTO = PetMapper.INSTANCE.convertList(pets);
        if (petsDTO.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(petsDTO, HttpStatus.OK);
    }

    // http://localhost:8090/pet/all/discharge
    @GetMapping("/all/discharge")
    public ResponseEntity<List<PetDTO>> showAllPetsDischarged() {
        List<Pet> pets = petService.findPetsDischarged();
        List<PetDTO> petsDTO = PetMapper.INSTANCE.convertList(pets);
        if (petsDTO.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(petsDTO, HttpStatus.OK);
    }
}
