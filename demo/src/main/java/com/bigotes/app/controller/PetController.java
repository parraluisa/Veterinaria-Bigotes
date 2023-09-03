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


@Controller
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @Autowired
    private OwnerService ownerService;


    

    @GetMapping("/all")
    public String showAllPets(Model model){
        model.addAttribute("pets", petService.findAll());
        return "pet_pages/show_all_pets";
    }

    // http://localhost:8090/pet/find/1
    @GetMapping("/find/{id}")
    public String showPet(Model model, @PathVariable("id") Long id) {
        Pet pet = petService.findById(id);
        if (pet != null) {
            model.addAttribute("pet", pet);
        } else {
            throw new NotFoundException();
        }
        return "pet_pages/show_pet";
    }

    @PostMapping("/save")
    public String savePet(@ModelAttribute("pet") Pet pet, @RequestParam("ownerId") Long ownerId) {
        Owner owner = ownerService.findByIdCard(ownerId);
        pet.setOwner(owner);
        petService.save(pet);
        return "redirect:/pet/all";
    }

    @GetMapping("/add")
    public String insertPet(Model model) {
        Pet pet = new Pet();
        model.addAttribute("pet", pet);
        model.addAttribute("ownerId", 0L);
        return "pet_pages/save_pet";
    }

    @GetMapping("/upd/{id}")
    public String updatePet(Model model, @PathVariable("id") Long id) {
        Pet pet = petService.findById(id);
        if (pet != null) {
            model.addAttribute("pet", pet);
        } else {
            throw new NotFoundException();
        }
        return "pet_pages/save_pet";
    }

    @GetMapping("/del/{id}")
    public String deletePet(@PathVariable("id") Long id) {
        Pet pet = petService.findById(id);
        if (pet != null) {
            petService.deleteById(id);
        } else {
            throw new NotFoundException();
        }
        return "redirect:/pet/all";
    }
}