package com.bigotes.app.repository;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bigotes.app.model.Owner;
import com.bigotes.app.model.Pet;
import com.bigotes.app.model.Treatment;
import com.bigotes.app.model.Veterinarian;

@DataJpaTest
@RunWith(SpringRunner.class)
public class DrugRepositoryTest {

    @Autowired
    private DrugRepositoryTest drugRepositoryTest;

    @Autowired
    private VeterinarianRepository veterinarianRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private TreatmentRepository

    @BeforeEach
    void init(){

        // Create owner 1
        ownerRepository.save(new Owner(1001298925L, "Esteban", "Gómez", "Buitrago", "3116721345", "esteban.buitrago@gmail.com"));
        // Create owner 2
        ownerRepository.save(new Owner(1234567890L, "Jane", "Smith", "Doe", "5555678", "jane.smith@example.com"));
        
        // Crear mascota 1
        petRepository.save(new Pet("Pompita", "British Shorthair", LocalDate.of(2015, 2, 12), 824.65, "Hipotiroidismo", "https://catinaflat.blog/wp-content/uploads/2022/03/british-shorthair-1.jpg"));
        // Crear mascota 2
        petRepository.save(new Pet("Fifi", "Abisinio", LocalDate.of(2023, 7, 24), 200.00, "rinotraqueítis felina", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse4.mm.bing.net%2Fth%3Fid%3DOIP.vBdcyqdY0z6igk5tfrflTQHaHa%26pid%3DApi&f=1&ipt=9a4ae16ea2d8f1a780e82c8a1ccbdbd022e6cfd3d22a02b712097477650fd6ac&ipo=images"));
        // Crear mascota 3
        petRepository.save(new Pet("Mimosa", "Maine Coon", LocalDate.of(2020, 4, 15), 4065.82, "Conjuntivitis", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.Dg-lJLyICJTPKLDcKOuYtgHaEo%26pid%3DApi&f=1&ipt=74cb2a44995bd708e41b783acc38bbe08949fdf0f140e082347bd5ab5efa6dd6&ipo=images"));
        
        // Crear veterinario 1
        veterinarianRepository.save(new Veterinarian(1000612796L ,"Andrés", "Garcia", "Montoya", "1234", "Cirujano", "https://images.pexels.com/photos/5327585/pexels-photo-5327585.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"));
        // Crear veterinario 2
        veterinarianRepository.save(new Veterinarian(1000612797L ,"Maria", "Lopez", "Rodriguez", "5678", "Dermatologo", "https://images.pexels.com/photos/5407206/pexels-photo-5407206.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"));
        // Crear veterinario 3
        veterinarianRepository.save(new Veterinarian(1000612798L ,"Carlos", "Martinez", "Perez", "4321", "Cardiologo", "https://images.pexels.com/photos/5327921/pexels-photo-5327921.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"));
        
        // Create and save treatment 1
        treatmentRepository.save(new Treatment(LocalDate.of(2023, 10, 2),  "Se le dió al felino el primer comprimido de FELIMAZOLE, revisión dentro de 12 horas."));
        // Create and save treatment 2
        treatmentRepository.save(new Treatment(LocalDate.of(2023, 10, 1), "Se administró Famciclovir para tratar la rinotraqueítis felina. Se realizará un seguimiento en 24 horas.") );
        // Create and save treatment 3
        treatmentRepository.save(new Treatment(LocalDate.of(2023, 10, 2), "Se aplicó PawPain Away al gato para aliviar el dolor en las patas. Revisión dentro de 12 horas para evaluar el alivio del dolor."));
        // Create and save treatment 4
        treatmentRepository.save(new Treatment(LocalDate.of(2023, 10, 2), "Se suministró WhiskerWellness al gato para mejorar su bienestar general y salud. Próxima revisión en 24 horas."));
        
    }
}
