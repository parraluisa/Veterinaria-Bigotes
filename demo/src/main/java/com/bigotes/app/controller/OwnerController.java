package com.bigotes.app.controller;

import com.bigotes.app.model.Owner;
import com.bigotes.app.model.UserEntity;
import com.bigotes.app.security.CustomUserDetailService;
import com.bigotes.app.service.OwnerService;
import com.bigotes.app.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owner")
@CrossOrigin(origins = "http://localhost:4200")
public class OwnerController {

    @Autowired
    OwnerService ownerService;
    @Autowired
    PetService petService;
    @Autowired
    CustomUserDetailService customUserDetailService;

    // Obtener todos los propietarios
    @GetMapping()
    public ResponseEntity<List<Owner>> showAllOwners() {
        List<Owner> owners = ownerService.findAll();
        return new ResponseEntity<>(owners, HttpStatus.OK);
    }

    // Obtener un propietario por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Owner> showOwner(@PathVariable("id") Long id) {
        Owner owner = ownerService.findById(id);
        if (owner != null) {
            return new ResponseEntity<>(owner, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Obtener el propietario por el ID de su mascota
    @GetMapping("/pet/{petId}")
    public ResponseEntity<Owner> getOwnerByPetId(@PathVariable("petId") Long petId) {
        Owner owner = ownerService.findOwnerByPetId(petId);
        if (owner != null) {
            return new ResponseEntity<>(owner, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Insertar un nuevo propietario
    @PostMapping()
    public ResponseEntity<Void> insertOwner(@RequestBody Owner owner) {
        UserEntity user = customUserDetailService.saveOwner(owner);
        owner.setUserEntity(user);
        ownerService.save(owner);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Actualizar un propietario
    @PutMapping()
    public ResponseEntity<Void> updateOwner(@RequestBody Owner owner) {
        if (ownerService.findById(owner.getId()) != null) {
            UserEntity user = customUserDetailService.saveOwner(owner);
            owner.setUserEntity(user);
            ownerService.save(owner);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un propietario por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOwner(@PathVariable("id") Long id) {
        if (ownerService.findById(id) != null) {
            ownerService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Verificar si un propietario existe por número de identificación (ID Card)
    @GetMapping("/exists/idCard/{idCard}")
    public ResponseEntity<Boolean> ownerExistsByIdCard(@PathVariable("idCard") Long idCard) {
        boolean exists = ownerService.existsByIdCard(idCard);
        return new ResponseEntity<>(exists, HttpStatus.OK);
    }

    // Verificar si un propietario existe por dirección de correo electrónico
    @GetMapping("/exists/email/{email}")
    public ResponseEntity<Boolean> ownerExistsByEmail(@PathVariable("email") String email) {
        boolean exists = ownerService.existsByEmail(email);
        return new ResponseEntity<>(exists, HttpStatus.OK);
    }

    // Verificar si un propietario existe por número de teléfono
    @GetMapping("/exists/phone/{phone}")
    public ResponseEntity<Boolean> ownerExistsByPhone(@PathVariable("phone") String phone) {
        boolean exists = ownerService.existsByPhone(phone);
        return new ResponseEntity<>(exists, HttpStatus.OK);
    }

    // Obtener un propietario por su número de identificación (ID Card)
    @GetMapping("/idCard/{idCard}")
    public ResponseEntity<Owner> getOwnerByIdCard(@PathVariable("idCard") Long idCard) {
        Owner owner = ownerService.findByIdCard(idCard);
        if (owner != null) {
            return new ResponseEntity<>(owner, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
