package com.bigotes.app.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bigotes.app.model.Administrator;
import com.bigotes.app.model.Owner;
import com.bigotes.app.model.UserEntity;
import com.bigotes.app.security.JWTGenerator;
import com.bigotes.app.service.AdministratorService;
import com.bigotes.app.service.OwnerService;
import com.bigotes.app.service.VeterinarianService;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginPageController {

    @Autowired
    OwnerService ownerService;

    @Autowired
    VeterinarianService veterinarianService;

    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTGenerator jwtGenerator;

    @GetMapping("/owner/{idCardOwner}")
    public Owner loginOwner(@PathVariable("idCardOwner") Long idCardOwner) {
        return ownerService.findByIdCard(idCardOwner);
    }

    /*
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

     */

    @PostMapping("/vet")
    public ResponseEntity<String> loginVet(@RequestBody UserEntity vet) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(vet.getUsername(), vet.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtGenerator.generateToken(authentication);
            return new ResponseEntity<>(token, HttpStatus.OK);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>("Authentication failed", HttpStatus.UNAUTHORIZED);
        }
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
