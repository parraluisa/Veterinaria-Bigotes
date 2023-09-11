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
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    OwnerService ownerService;
    @Autowired
    PetService petService;
    // http://localhost:8090/owner/all
    @GetMapping("/all")
    public String showAllOwners(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "owner_pages/show_all_owners";
    }

    // http://localhost:8090/owner/find/1
    @GetMapping("/find/{id}")
    public String showOwner(Model model, @PathVariable("id") Long id) {
        Owner owner = ownerService.findById(id);
        if (owner != null) {
            model.addAttribute("owner", owner);
        } else {
            throw new NotFoundException();
        }
        return "owner_pages/show_owner";
    }
    // http://localhost:8090/owner/save
    @PostMapping("/save")
    public String saveOwner(@ModelAttribute("owner") Owner owner) {
        ownerService.save(owner);
        return "redirect:/owner/all";
    }
    // http://localhost:8090/owner/add
    @GetMapping("/add")
    public String insertOwner(Model model) {
        Owner owner = new Owner();
        model.addAttribute("owner", owner);
        return "owner_pages/save_owner";
    }
    // http://localhost:8090/owner/upd/1
    @GetMapping("/upd/{id}")
    public String updateOwner(Model model, @PathVariable("id") Long id) {
        Owner owner = ownerService.findById(id);
        if (owner != null) {
            model.addAttribute("owner", owner);
        } else {
            throw new NotFoundException();
        }
        return "owner_pages/save_owner";
    }
    // http://localhost:8090/owner/del/1
    @GetMapping("/del/{id}")
    public String deleteOwner(@PathVariable("id") Long id) {
        Owner owner = ownerService.findById(id);
        if (owner != null) {
            ownerService.deleteById(id);
        } else {
            throw new NotFoundException();
        }
        return "redirect:/owner/all";
    }
    // http://localhost:8090/owner/pets/1
    @GetMapping("/pets/{id}")
    public String showOwnerPets(Model model, @PathVariable("id") Long id){
        model.addAttribute("pets", petService.findByOwnerId(id));
        return "owner_pages/owner_pets";
    }

    // http://localhost:8090/owner/pet/find/{idPet}
    @GetMapping("/pet/find/{id}")
    public String showOwnerPet(Model model, @PathVariable("id") Long id){
        Pet pet = petService.findById(id);
        System.out.println(id);
        if (pet != null) {
            model.addAttribute("pet", pet);
        } else {
            throw new NotFoundException();
        }
        return "owner_pages/owner_pet";
    }
    //localhost:8090/owner/find/pets/{idOwner}
    @GetMapping("/find/pets/{id}")
    public String showAllPetsByOwner(Model model, @PathVariable("id") Long id){
        //Obtenr todas las mascotas del dueño y luego mostrarlas en la vista
        model.addAttribute("pets", petService.findByOwnerId(id));
        return "pet_pages/show_all_pets";
    }
}
