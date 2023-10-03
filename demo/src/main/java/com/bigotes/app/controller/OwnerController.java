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

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    OwnerService ownerService;
    @Autowired
    PetService petService;

    // http://localhost:8090/owner/all
    @GetMapping("/all")
    public Collection<Owner> showAllOwners() {
        return ownerService.findAll();
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
    @PostMapping("/add")
    public void insertOwner(@RequestBody Owner owner) {
        ownerService.save(owner);
    }

    // http://localhost:8090/owner/upd/1
    @PutMapping("/upd/{id}")
    public void updateOwner(@RequestBody Owner owner, @PathVariable("id") Long id) {
        ownerService.save(owner);
    }

    // http://localhost:8090/owner/del/1
    @DeleteMapping("/del/{id}")
    public void deleteOwner(@PathVariable("id") Long id) {
        ownerService.deleteById(id);
    }

    // http://localhost:8090/owner/login
    @GetMapping("/login")
    public String showLogin(Model model) {
        Integer idCard = 0;
        model.addAttribute("idCard", idCard);
        return "login_page";
    }
    // http://localhost:8090/owner/login
    @PostMapping("/login")
    public String login(@RequestParam("idCard") Long idCard) {
        Owner owner = ownerService.findByIdCard(idCard);
        if (owner != null) {
            return "redirect:/owner/pets/" + owner.getId();
        } else {
            return "redirect:/owner/login?error=idNotFound";
        }
    }
    // http://localhost:8090/owner/pets/1
    @GetMapping("/pets/{id}")
    public String showOwnerPets(Model model, @PathVariable("id") Long id){
        model.addAttribute("pets", petService.findByOwnerId(id));
        return "owner_pages/owner_pets";
    }

    // http://localhost:8090/owner/pet/find/1
    @GetMapping("/pet/find/{id}")
    public String showOwnerPet(Model model, @PathVariable("id") Long id){
        Pet pet = petService.findById(id);
        if (pet != null) {
            model.addAttribute("pet", pet);
        } else {
            throw new NotFoundException();
        }
        return "owner_pages/owner_pet";
    }
    //localhost:8090/owner/find/pets/1
    @GetMapping("/find/pets/{id}")
    public String showAllPetsByOwner(Model model, @PathVariable("id") Long id){
        //Obtenr todas las mascotas del dueño y luego mostrarlas en la vista
        model.addAttribute("pets", petService.findByOwnerId(id));
        return "pet_pages/show_all_pets";
    }
}
