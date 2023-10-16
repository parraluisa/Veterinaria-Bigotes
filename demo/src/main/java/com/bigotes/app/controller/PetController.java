package com.bigotes.app.controller;

import com.bigotes.app.model.Pet;
import com.bigotes.app.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/pet")
@CrossOrigin(origins = "http://localhost:4200")
public class PetController {

    @Autowired
    private PetService petService;
    
    // http://localhost:8090/pet
    @GetMapping()
    public List<Pet> showAllPets(){
        return petService.findAll();
    }

    // http://localhost:8090/pet/{petId}
    @GetMapping("/{id}")
    public Pet showPet(@PathVariable("id") Long id) {
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
        System.out.println(pet);
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

    // Dashboard No. 05
    // Cantidad de mascotas totales en la veterinaria
    // http://localhost:8090/pet/count/total
    @GetMapping("/count/total")
    public Long countTotalPets(){
        return petService.countTotalPets();
    }

    // Dashboard No. 06
    // Cantidad de mascotas activas (en tratamiento) en la veterinaria
    // http://localhost:8090/pet/count/ontreatment
    @GetMapping("/count/ontreatment")
    public Long countActivePets(){
        return petService.countActivePets();
    }

}