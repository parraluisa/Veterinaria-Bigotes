package com.bigotes.app.controller;

import com.bigotes.app.DTOs.UserDTO;
import com.bigotes.app.model.Owner;
import com.bigotes.app.model.UserEntity;
import com.bigotes.app.security.JWTGenerator;
import com.bigotes.app.service.AdministratorService;
import com.bigotes.app.service.OwnerService;
import com.bigotes.app.service.UserService;
import com.bigotes.app.service.VeterinarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

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
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTGenerator jwtGenerator;

    @GetMapping("/owner/{idCardOwner}")
    public Owner loginOwner(@PathVariable("idCardOwner") Long idCardOwner) {
        return ownerService.findByIdCard(idCardOwner);
    }

    @PostMapping("/vet")
    public ResponseEntity<?> loginVet(@RequestBody UserEntity vet) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(vet.getUsername(), vet.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtGenerator.generateToken(authentication);

            vet = userService.findByUsername(vet.getUsername());

            boolean isVet = vet.getRoles().stream()
                    .anyMatch(role -> "VET".equals(role.getName()));

            if (isVet) {
                return new ResponseEntity<>(token, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } catch (AuthenticationException e) {
            System.out.println(vet);
            return new ResponseEntity<>("Authentication failed", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/admin")
    public ResponseEntity<String> loginAdmin(@RequestBody UserEntity admin) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(admin.getUsername(), admin.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtGenerator.generateToken(authentication);

            admin = userService.findByUsername(admin.getUsername());

            boolean isAdmin = admin.getRoles().stream()
                    .anyMatch(role -> "ADMIN".equals(role.getName()));

            if (isAdmin) {
                return new ResponseEntity<>(token, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Authentication failed", HttpStatus.UNAUTHORIZED);
            }
        } catch (AuthenticationException e) {
            return new ResponseEntity<>("Authentication failed", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/userType")
    public ResponseEntity<?> getUserTypeFromJWT(@RequestBody String jwt) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(jwt);
        if (jwtGenerator.validateToken(jwt)) {
            String username = jwtGenerator.getUserFromJwt(jwt);
            UserEntity user = userService.findByUsername(Long.valueOf(username));
            if (user == null) {
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            }
            UserDTO userDTO = new UserDTO();
            userDTO.setIdCard(user.getUsername());
            userDTO.setRole(user.getRoles().get(0).getName());
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid token", HttpStatus.UNAUTHORIZED);
        }
    }

}
