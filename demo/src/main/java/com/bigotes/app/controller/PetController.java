package com.bigotes.app.controller;

import com.bigotes.app.exception.NotFoundException;
import com.bigotes.app.model.Owner;
import com.bigotes.app.model.Pet;
import com.bigotes.app.service.OwnerService;
import com.bigotes.app.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @Autowired
    private OwnerService ownerService;
    
    // http://localhost:8090/pet
    @GetMapping()
    public List<Pet> showAllPets(Model model){
        return petService.findAll();
    }

    // http://localhost:8090/pet/{petId}
    @GetMapping("/{id}")
    public Pet showPet(Model model, @PathVariable("id") Long id) {
        return petService.findById(id);
    }

    // http://localhost:8090/pet
    @PostMapping()
    public void insertPet(@RequestBody Pet pet) {
        petService.save(pet);
    }
    
    // http://localhost:8090/pet
    @PutMapping()
    public void updatePet(@RequestBody Pet pet) {
        petService.save(pet);
    }

    // http://localhost:8090/pet/{petId}
    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable("id") Long id) {
        petService.deleteById(id);
    }

    //Cambiar a pets
    // http://localhost:8090/pet/owner/{id}
    @GetMapping("/owner/{id}")
    public List<Pet> showOwnerPet(@PathVariable("id") Long id){
        return petService.findByOwnerId(id);
    }
}