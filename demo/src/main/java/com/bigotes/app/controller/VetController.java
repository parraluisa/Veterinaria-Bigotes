package com.bigotes.app.controller;

import com.bigotes.app.DTOs.VeterinarianDTO;
import com.bigotes.app.DTOs.VeterinarianMapper;
import com.bigotes.app.model.UserEntity;
import com.bigotes.app.model.Veterinarian;
import com.bigotes.app.security.CustomUserDetailService;
import com.bigotes.app.service.UserService;
import com.bigotes.app.service.VeterinarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vet")
@CrossOrigin(origins = "http://localhost:4200")
public class VetController {

    @Autowired
    private VeterinarianService veterinarianService;

    @Autowired
    private UserService userService;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    // Obtener todos los veterinarios
    @GetMapping()
    public ResponseEntity<List<VeterinarianDTO>> showAllVets() {
        List<Veterinarian> vets = veterinarianService.findAll();
        List<VeterinarianDTO> vetsDTO = VeterinarianMapper.INSTANCE.convertList(vets);
        return new ResponseEntity<>(vetsDTO, HttpStatus.OK);
    }

    // Obtener un veterinario por su ID
    @GetMapping("/{id}")
    public ResponseEntity<VeterinarianDTO> showVet(@PathVariable("id") Long id) {
        Veterinarian vet = veterinarianService.findById(id);
        VeterinarianDTO vetDTO = VeterinarianMapper.INSTANCE.convert(vet);
        if (vetDTO != null) {
            return new ResponseEntity<>(vetDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Obtener un veterinario por su número de identificación (ID Card)
    @GetMapping("/idcard/{id}")
    public ResponseEntity<?> showVetByIdCard(@PathVariable("id") Long id) {
        Veterinarian vet = veterinarianService.findByIdCard(id);
        VeterinarianDTO vetDTO = VeterinarianMapper.INSTANCE.convert(vet);
        if (vetDTO != null) {
            return new ResponseEntity<>(vetDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Insertar un nuevo veterinario
    @PostMapping()
    public ResponseEntity<Void> insertVet(@RequestBody Veterinarian vet) {

        if (userService.existsByUsername(vet.getIdCard())) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        UserEntity userEntity = customUserDetailService.saveVeterinarian(vet);
        vet.setUserEntity(userEntity);
        veterinarianService.save(vet);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Actualizar un veterinario
    @PutMapping()
    public ResponseEntity<Void> updateVet(@RequestBody Veterinarian vet) {
        if (veterinarianService.findById(vet.getId()) != null) {
            veterinarianService.save(vet);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un veterinario por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVet(@PathVariable("id") Long id) {
        if (veterinarianService.findById(id) != null) {
            veterinarianService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Verificar si un veterinario existe por número de identificación (ID Card)
    @GetMapping("/exists/{idCard}")
    public ResponseEntity<Boolean> vetExists(@PathVariable("idCard") Long idCard) {
        boolean exists = veterinarianService.existsByIdCard(idCard);
        return new ResponseEntity<>(exists, HttpStatus.OK);
    }

    // Dashboard No. 03
    // Cantidad de veterinarios activos en la plataforma
    @GetMapping("/count/active")
    public ResponseEntity<Long> countActiveVeterinarians() {
        Long count = veterinarianService.countActiveVeterinarians();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    // Dashboard No. 04
    // Cantidad de veterinarios inactivos en la plataforma
    @GetMapping("/count/inactive")
    public ResponseEntity<Long> countInactiveVeterinarians() {
        Long count = veterinarianService.countInactiveVeterinarians();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    // Todos los veterinarios que esten activos
    //localhost:8080/vet/active
    @GetMapping("/active")
    public ResponseEntity<List<VeterinarianDTO>> findAllActiveVeterinarian() {
        List<Veterinarian> vets = veterinarianService.findAllActiveVeterinarian();
        List<VeterinarianDTO> vetsDTO = VeterinarianMapper.INSTANCE.convertList(vets);
        if(vetsDTO.isEmpty()) 
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(vetsDTO, HttpStatus.OK);
    }

    // Todos los veterinarios que esten inactivos
    //localhost:8080/vet/inactive
    @GetMapping("/inactive")
    public ResponseEntity<List<VeterinarianDTO>> findAllInactiveVeterinarian() {
        List<Veterinarian> vets = veterinarianService.findAllInactiveVeterinarian();
        List<VeterinarianDTO> vetsDTO = VeterinarianMapper.INSTANCE.convertList(vets);
        if(vetsDTO.isEmpty()) 
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(vetsDTO, HttpStatus.OK);
    }
}
