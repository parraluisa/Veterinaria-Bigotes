package com.bigotes.app.controller;

import com.bigotes.app.model.Administrator;
import com.bigotes.app.model.Owner;
import com.bigotes.app.model.Veterinarian;
import com.bigotes.app.service.AdministratorService;
import com.bigotes.app.service.OwnerService;
import com.bigotes.app.service.VeterinarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginPageController {

    @Autowired
    OwnerService ownerService;

    @Autowired
    VeterinarianService veterinarianService;

    @Autowired
    AdministratorService administratorService;

    @GetMapping("/owner/{idCardOwner}")
    public Owner loginOwner(@PathVariable("idCardOwner") Long idCardOwner) {
        return ownerService.findByIdCard(idCardOwner);
    }

    @GetMapping("/vet/{idCardVet}/{passwordVet}")
    public Veterinarian loginVet(
            @PathVariable("idCardVet") Long idCardVet,
            @PathVariable("passwordVet") String passwordVet
    ) {
        Veterinarian vet = veterinarianService.findByIdCard(idCardVet);
        if (vet != null && Objects.equals(vet.getPassword(), passwordVet)) {
            return vet;
        }
        return null;
    }

    @GetMapping("/admin/{idCardAdmin}/{passwordAdmin}")
    public Boolean loginAdmin(
            @PathVariable("idCardAdmin") Long idCardAdmin,
            @PathVariable("passwordAdmin") String passwordAdmin
    ) {
        Administrator admin = administratorService.findByIcCard(idCardAdmin);
        return admin != null && Objects.equals(admin.getPassword(), passwordAdmin);
    }

}
