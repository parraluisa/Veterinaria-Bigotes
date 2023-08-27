package com.bigotes.app.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bigotes.app.exception.NotFoundException;
import com.bigotes.app.model.Pet;
import com.bigotes.app.service.CrudService;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/pet")
public class PetController {
    @Autowired
    CrudService<Pet> service;

    @GetMapping("/all")
    public String showAllPets(Model model){
        model.addAttribute("pets", service.findAll());
        return "pet_pages/show_all_pets";
    }

    // http://localhost:8090/pet/find/1
    @GetMapping("/find/{id}")
    public String showPet(Model model, @PathVariable("id") int id) {
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
        Pet pet = new Pet(0, "", "", "", 0, 0.0, "", LocalDate.now(), LocalDate.now());
        model.addAttribute("pet", pet);
        return "pet_pages/save_pet";
    }

    @GetMapping("/upd/{id}")
    public String updatePet(Model model, @PathVariable("id") int id) {
        Pet pet = service.findById(id);
        if (pet != null) {
            model.addAttribute("pet", pet);
        } else {
            throw new NotFoundException();
        }
        return "pet_pages/save_pet";
    }

    @GetMapping("/del/{id}")
    public String deletePet(Model model, @PathVariable("id") int id) {
        Pet pet = service.findById(id);
        if (pet != null) {
            service.deleteById(id);
        } else {
            throw new NotFoundException();
        }
        return "redirect:/pet/all";
    }    
}