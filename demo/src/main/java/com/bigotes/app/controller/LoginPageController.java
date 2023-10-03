package com.bigotes.app.controller;

import com.bigotes.app.model.Owner;
import com.bigotes.app.model.Veterinarian;
import com.bigotes.app.service.OwnerService;
import com.bigotes.app.service.VeterinarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
@RequestMapping("/login")
public class LoginPageController {

    @Autowired
    OwnerService ownerService;

    @Autowired
    VeterinarianService veterinarianService;

    @PostMapping("/owner")
    public String loginOwner(@RequestParam("idCardOwner") Long idCardOwner) {
        Owner owner = ownerService.findByIdCard(idCardOwner);
        if (owner != null) {
            return "redirect:/owner/pets/" + owner.getId();
        } else {
            return "redirect:/login/show?error=idNotFound";
        }
    }

    @PostMapping("/vet")
    public String loginVet(
            @RequestParam("idCardVet") Long idCardVet,
            @RequestParam("passwordVet") String passwordVet
    ) {
        Veterinarian vet = veterinarianService.findByIdCard(idCardVet);

        if (vet != null && Objects.equals(vet.getPassword(), passwordVet)) {
            return "redirect:/pet/all";
        }

        return "redirect:/login/show?error=loginVetFailed";
    }

}
