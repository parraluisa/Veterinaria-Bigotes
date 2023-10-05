package com.bigotes.app.controller;

import com.bigotes.app.model.Owner;
import com.bigotes.app.service.OwnerService;
import com.bigotes.app.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
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

    // http://localhost:8090/owner
    @GetMapping()
    public List<Owner> showAllOwners() {
        return ownerService.findAll();
    }

    // http://localhost:8090/owner/{id}
    @GetMapping("/{id}")
    public Owner showOwner(@PathVariable("id") Long id) {
        return ownerService.findById(id);
    }

    // http://localhost:8090/owner
    @PostMapping()
    public void insertOwner(@RequestBody Owner owner) {
        ownerService.save(owner);
    }

    // http://localhost:8090/owner
    @PutMapping()
    public void updateOwner(@RequestBody Owner owner) {
        ownerService.save(owner);
    }

    // http://localhost:8090/owner/{id}
    @DeleteMapping("/{id}")
    public void deleteOwner(@PathVariable("id") Long id) {
        ownerService.deleteById(id);
    }
}
