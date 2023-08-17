package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entidad.Pet;
import com.example.demo.servicio.CrudService;

@Controller
@RequestMapping("/pet")
public class PetController {
    @Autowired
    CrudService<Pet> service;

    @GetMapping("/all")
    public String showAllPets(Model model){
        model.addAttribute("pets", service.SearchAll());
        System.out.println(service.SearchAll().size());
        return "show_all_pets";
    }

    // http://localhost:8090/student/find/1
    @GetMapping("/find/{id}")
    public String showPet(Model model, @PathVariable("id") int id) {

        Pet pet = service.SearchById(id);
        if (pet != null) {
            model.addAttribute("pet", pet);
        }

        return "show_pet";
    }
}
