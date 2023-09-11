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


@Controller
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @Autowired
    private OwnerService ownerService;


    
    // http://localhost:8090/pet/all
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
    // http://localhost:8090/pet/save
    @PostMapping("/save")
    public String savePet(
            @ModelAttribute("pet") Pet pet,
            @RequestParam("ownerId") Long ownerId,
            RedirectAttributes redirectAttributes) {

        Owner owner = ownerService.findByIdCard(ownerId);
        if (owner == null) {
            redirectAttributes.addAttribute("error", "idNotFound");
            return "redirect:/pet/add"; // Redirect to the add page with the error
        } else {
            pet.setOwner(owner);
            petService.save(pet);
            return "redirect:/pet/all";
        }
    }

    // http://localhost:8090/pet/add
    @GetMapping("/add")
    public String insertPet(Model model) {
        Pet pet = new Pet();
        model.addAttribute("pet", pet);
        model.addAttribute("ownerId", 0L);
        return "pet_pages/save_pet";
    }

    @GetMapping("/add/{ownerId}")
    public String insertPet(Model model, @PathVariable("ownerId") Long ownerId) {
        Pet pet = new Pet();
        Owner owner = new Owner();
        owner.setIdCard(ownerId);
        pet.setOwner(owner);
        model.addAttribute("pet", pet);
        return "pet_pages/save_pet";
    }
    
    // http://localhost:8090/pet/upd/1
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
    // http://localhost:8090/pet/del/1
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