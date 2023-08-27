package com.bigotes.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bigotes.app.exception.NotFoundException;
import com.bigotes.app.model.Owner;
import com.bigotes.app.service.CrudService;

@Controller
@RequestMapping("/owner")
public class OwnerController {
    @Autowired
    CrudService<Owner> service;

    @GetMapping("/all")
    public String showAllOwners(Model model) {
        model.addAttribute("owners", service.findAll());
        return "owner_pages/show_all_owners";
    }

    // http://localhost:8090/owner/find/1
    @GetMapping("/find/{id}")
    public String showOwner(Model model, @PathVariable("id") int id) {
        Owner owner = service.findById(id);
        if (owner != null) {
            model.addAttribute("owner", owner);
        } else {
            throw new NotFoundException();
        }
        return "owner_pages/show_owner";
    }

    @PostMapping("/save")
    public String saveOwner(@ModelAttribute("owner") Owner owner) {
        service.save(owner);
        return "redirect:/owner/all";
    }

    @GetMapping("/add")
    public String insertOwner(Model model) {
        Owner owner = new Owner(0, 0, "", "", "", ", ", ", ", ", ", null);
        model.addAttribute("owner", owner);
        return "owner_pages/save_owner";
    }

    @GetMapping("/upd/{id}")
    public String updateOwner(Model model, @PathVariable("id") int id) {
        Owner owner = service.findById(id);
        if (owner != null) {
            model.addAttribute("owner", owner);
        } else {
            throw new NotFoundException();
        }
        return "owner_pages/save_owner";
    }

    @GetMapping("/del/{id}")
    public String deleteOwner(Model model, @PathVariable("id") int id) {
        Owner owner = service.findById(id);
        if (owner != null) {
            service.deleteById(id);
        } else {
            throw new NotFoundException();
        }
        return "redirect:/owner/all";
    }
}
