package com.bigotes.app.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.bigotes.app.model.Veterinarian;

@DataJpaTest
public class VeterinarianRepositoryTest {
    @Autowired
    private VeterinarianRepository veterinarianRepository;

    @BeforeEach
    void init(){
        // Create veterinarian 1
        Veterinarian v1 = new Veterinarian(1000612796L ,"Andrés", "Garcia", "Montoya", "1234", "Cirujano", "https://images.pexels.com/photos/5327585/pexels-photo-5327585.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
        // Create veterinarian 2
        Veterinarian v2 = new Veterinarian(1000612797L ,"Maria", "Lopez", "Rodriguez", "5678", "Dermatologo", "https://images.pexels.com/photos/5407206/pexels-photo-5407206.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
        // Create veterinarian 3
        Veterinarian v3 = new Veterinarian(1000612798L ,"Juan", "Perez", "Gomez", "9101", "Oftalmologo", "https://images.pexels.com/photos/5407206/pexels-photo-5407206.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");

        v1 = veterinarianRepository.save(v1);
        v2 = veterinarianRepository.save(v2);
        v3 = veterinarianRepository.save(v3);


    }

    @Test
    public void VeterinarianRepository_countActiveVeterinarians_Long(){
        //Arrange
        //Act
        Long totalVeterinarians = veterinarianRepository.countActiveVeterinarians();
        //Assert
        Assertions.assertThat(totalVeterinarians).isNotNull();
        Assertions.assertThat(totalVeterinarians).isEqualTo(3);
    }

    @Test
    public void VeterinarianRepository_countInactiveVeterinarians_Long(){
        //Arrange
        //Act
        Long totalVeterinarians = veterinarianRepository.countInactiveVeterinarians();
        //Assert
        Assertions.assertThat(totalVeterinarians).isNotNull();
        Assertions.assertThat(totalVeterinarians).isEqualTo(0);
    }
}
