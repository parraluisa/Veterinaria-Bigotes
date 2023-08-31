package com.bigotes.app.controller;

import com.bigotes.app.model.Owner;
import com.bigotes.app.model.Pet;
import com.bigotes.app.repository.OwnerRepository;
import com.bigotes.app.repository.PetRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
@Transactional
public class DbController implements ApplicationRunner {
    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    PetRepository petRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // Create owner 1
        ownerRepository.save(new Owner(
                123456789L, "John", "Doe", "Smith",
                "555-1234", "john.doe@example.com"
        ));

        // Create owner 2
        ownerRepository.save(new Owner(
                987654321L, "Jane", "Smith", "Doe",
                "555-5678", "jane.smith@example.com"
        ));

        petRepository.save(new Pet("Bonifacio", "Persa", new Date(), 4.0, "Lupus", "https://placekitten.com/g/200/300"));


        Owner asociar = ownerRepository.findById(1L).get();
        for(Pet pet: petRepository.findAll()){
            pet.setOwner(asociar);
            petRepository.save(pet);
        }
    }
}
