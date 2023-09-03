package com.bigotes.app.controller;

import com.bigotes.app.exception.NotFoundException;
import com.bigotes.app.model.Pet;
import com.bigotes.app.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService service;

    

    @GetMapping("/all")
    public String showAllPets(Model model){
        model.addAttribute("pets", service.findAll());
        return "pet_pages/show_all_pets";
    }

    // http://localhost:8090/pet/find/1
    @GetMapping("/find/{id}")
    public String showPet(Model model, @PathVariable("id") Long id) {
        Pet pet = service.findById(id);
        if (pet != null) {
            model.addAttribute("pet", pet);
        } else {
            throw new NotFoundException();
        }
        return "pet_pages/show_pet";
    }

    @PostMapping("/save")
    public String savePet(@ModelAttribute("pet") Pet pet) {

        service.save(pet);
        return "redirect:/pet/all";
    }

    @GetMapping("/add")
    public String insertPet(Model model) {
        Pet pet = new Pet();
        model.addAttribute("pet", pet);
        return "pet_pages/save_pet";
    }

    @GetMapping("/upd/{id}")
    public String updatePet(Model model, @PathVariable("id") Long id) {
        Pet pet = service.findById(id);
        if (pet != null) {
            model.addAttribute("pet", pet);
        } else {
            throw new NotFoundException();
        }
        return "pet_pages/save_pet";
    }

    @GetMapping("/del/{id}")
    public String deletePet(@PathVariable("id") Long id) {
        Pet pet = service.findById(id);
        if (pet != null) {
            service.deleteById(id);
        } else {
            throw new NotFoundException();
        }
        return "redirect:/pet/all";
    }

    @GetMapping("/owner-pets/{id}")
    public String showOwnerPets(Model model, @PathVariable("id") Long id){
        model.addAttribute("pets", service.findByOwnerId(id));
        return "owner_pages/owner_pets";
    }


    @GetMapping("/owner-pet/find/{id}")
    public String showOwnerPet(Model model, @PathVariable("id") Long id){
        Pet pet = service.findById(id);
        if (pet != null) {
            model.addAttribute("pet", pet);
        } else {
            throw new NotFoundException();
        }
        return "owner_pages/owner_pet";
    }
}