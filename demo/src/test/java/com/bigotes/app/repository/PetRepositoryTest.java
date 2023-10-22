package com.bigotes.app.repository;

import java.time.LocalDate;

import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.bigotes.app.model.Owner;
import com.bigotes.app.model.Pet;

@DataJpaTest
public class PetRepositoryTest {
    @Autowired
    private PetRepository petRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @BeforeEach
    void init(){
        // Create owner 1
        Owner owner1 = ownerRepository.save(new Owner(1001298925L, "Esteban", "Gómez", "Buitrago", "3116721345", "esteban.buitrago@gmail.com"));
        // Create owner 2
        Owner owner2 = ownerRepository.save(new Owner(1234567890L, "Jane", "Smith", "Doe", "5555678", "jane.smith@example.com"));


        // Create pet 1
        Pet pet1 = new Pet("Pompita", "British Shorthair", LocalDate.of(2015, 2, 12), 824.65, "Hipotiroidismo", "https://catinaflat.blog/wp-content/uploads/2022/03/british-shorthair-1.jpg");
        // Create pet 2
        Pet pet2 = new Pet("Fifi", "Abisinio", LocalDate.of(2023, 7, 24), 200.00, "rinotraqueítis felina", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse4.mm.bing.net%2Fth%3Fid%3DOIP.vBdcyqdY0z6igk5tfrflTQHaHa%26pid%3DApi&f=1&ipt=9a4ae16ea2d8f1a780e82c8a1ccbdbd022e6cfd3d22a02b712097477650fd6ac&ipo=images");
        // Create pet 3
        Pet pet3 = new Pet("Mimosa", "Maine Coon", LocalDate.of(2020, 4, 15), 4065.82, "Conjuntivitis", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.Dg-lJLyICJTPKLDcKOuYtgHaEo%26pid%3DApi&f=1&ipt=74cb2a44995bd708e41b783acc38bbe08949fdf0f140e082347bd5ab5efa6dd6&ipo=images");

        pet1.setOwner(owner1);
        pet2.setOwner(owner1);
        pet3.setOwner(owner2);

        pet1 = petRepository.save(pet1);
        pet2 = petRepository.save(pet2);
        pet3 = petRepository.save(pet3);
    }

    @Test
    public void PetRepository_countTotalPets_Long(){
        //Arrange
        //Act
        Long totalPets = petRepository.countTotalPets();
        //Assert
        Assertions.assertThat(totalPets).isNotNull();
        Assertions.assertThat(totalPets).isEqualTo(3);
    }

    @Test void PetRepository_countActivePets_Long(){
        //Arrange
        //Act
        Long totalActivePets = petRepository.countActivePets();
        //Assert
        Assertions.assertThat(totalActivePets).isNotNull();
        Assertions.assertThat(totalActivePets).isEqualTo(3);
    }
    
}
