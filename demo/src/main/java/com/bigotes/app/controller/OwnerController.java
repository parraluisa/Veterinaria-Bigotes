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

    @PostMapping("/save")
    public String saveOwner(@ModelAttribute("owner") Owner owner) {
        ownerService.save(owner);
        return "redirect:/owner/all";
    }

    @GetMapping("/add")
    public String insertOwner(Model model) {
        Owner owner = new Owner();
        model.addAttribute("owner", owner);
        return "owner_pages/save_owner";
    }

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

    @GetMapping("/login")
    public String showLogin(Model model) {
        Integer idCard = 0;
        model.addAttribute("idCard", idCard);
        return "login_page";
    }

    @PostMapping("/login")
    public String login(@RequestParam("idCard") Long idCard) {
        Owner owner = ownerService.findByIdCard(idCard);
        if (owner != null) {
            return "redirect:/owner/pets/" + owner.getId();
        } else {
            return "redirect:/owner/login?error=idNotFound";
        }
    }

    @GetMapping("/pets/{id}")
    public String showOwnerPets(Model model, @PathVariable("id") Long id){
        model.addAttribute("pets", petService.findByOwnerId(id));
        return "owner_pages/owner_pets";
    }


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
}
