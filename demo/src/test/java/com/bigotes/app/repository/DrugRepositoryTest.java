package com.bigotes.app.repository;

import com.bigotes.app.model.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@DataJpaTest
//@RunWith(SpringRunner.class)
public class DrugRepositoryTest {

    @Autowired
    private DrugRepository drugRepository;

    @Autowired
    private VeterinarianRepository veterinarianRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private TreatmentRepository treatmentRepository;

    @BeforeEach
    void init() {

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

        // Create vet 1
        Veterinarian vet1 = veterinarianRepository.save(new Veterinarian(1000612796L, "Andrés", "Garcia", "Montoya", "1234", "Cirujano", "https://images.pexels.com/photos/5327585/pexels-photo-5327585.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"));
        // Create vet 2
        Veterinarian vet2 = veterinarianRepository.save(new Veterinarian(1000612797L, "Maria", "Lopez", "Rodriguez", "5678", "Dermatologo", "https://images.pexels.com/photos/5407206/pexels-photo-5407206.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"));
        // Create vet 3
        Veterinarian vet3 = veterinarianRepository.save(new Veterinarian(1000612798L, "Carlos", "Martinez", "Perez", "4321", "Cardiologo", "https://images.pexels.com/photos/5327921/pexels-photo-5327921.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"));

        // Create and save treatment 1
        Treatment treatment1 = new Treatment(LocalDate.of(2023, 10, 2), "Se le dió al felino el primer comprimido de FELIMAZOLE, revisión dentro de 12 horas.");
        // Create and save treatment 2
        Treatment treatment2 = new Treatment(LocalDate.of(2023, 10, 1), "Se administró Famciclovir para tratar la rinotraqueítis felina. Se realizará un seguimiento en 24 horas.");
        // Create and save treatment 3
        Treatment treatment3 = new Treatment(LocalDate.of(2023, 10, 2), "Se aplicó PawPain Away al gato para aliviar el dolor en las patas. Revisión dentro de 12 horas para evaluar el alivio del dolor.");
        // Create and save treatment 4
        Treatment treatment4 = new Treatment(LocalDate.of(2023, 10, 2), "Se suministró WhiskerWellness al gato para mejorar su bienestar general y salud. Próxima revisión en 24 horas.");

        // Create and save drug 1
        Drug drug1 = drugRepository.save(new Drug("ACOLAN", 100.00f, 200.00f, 15, 35));
        // Create and save drug 2
        Drug drug2 = drugRepository.save(new Drug("BACIVET", 200.00f, 400.00f, 11, 5));
        // Create and save drug 3
        Drug drug3 = drugRepository.save(new Drug("BISEPTYL", 300.00f, 600.00f, 5, 10));

        treatment1.setPet(pet1);
        treatment2.setPet(pet2);
        treatment3.setPet(pet3);
        treatment4.setPet(pet3);

        treatment1.setDrug(drug1);
        treatment2.setDrug(drug2);
        treatment3.setDrug(drug3);
        treatment4.setDrug(drug3);

        treatment1.setVeterinarian(vet1);
        treatment2.setVeterinarian(vet2);
        treatment3.setVeterinarian(vet3);
        treatment4.setVeterinarian(vet3);

        treatmentRepository.save(treatment1);
        treatmentRepository.save(treatment2);
        treatmentRepository.save(treatment3);
        treatmentRepository.save(treatment4);
    }

    @Test
    public void DrugRepository_save_Drug() {
        //Arrange
        Drug drug = new Drug("BOFLOX", 100.00f, 200.00f, 15, 35);
        //Act
        Drug savedDrug = drugRepository.save(drug);
        //Assert
        Assertions.assertThat(savedDrug).isNotNull();
    }

    @Test
    public void DrugRepository_FindAll_NotEmptyList() {
        //Arrange
        Drug drug4 = drugRepository.save(new Drug("BOFLOX", 200.00f, 400.00f, 11, 5));
        Drug drug5 = drugRepository.save(new Drug("CADOREX", 300.00f, 600.00f, 5, 10));
        //Act
        drugRepository.save(drug4);
        drugRepository.save(drug5);
        List<Drug> drugs = drugRepository.findAll();
        //Assert
        Assertions.assertThat(drugs).isNotNull();
        Assertions.assertThat(drugs.size()).isEqualTo(5);
    }

    @Test
    public void DrugRepository_FindById_FindWrongIndex() {
        //Arrange
        Long index = -1L;
        //Act
        Optional<Drug> drug = drugRepository.findById(index);
        //Assert
        Assertions.assertThat(drug).isEmpty();
    }

    @Test
    public void DrugRepository_DeleteById_EmptyStudent() {
        //Arrange
        Long index = 2L;
        //Act
        drugRepository.deleteById(index);
        //Assert
        Assertions.assertThat(drugRepository.findById(index)).isEmpty();
    }


    @Test
    public void DrugRepository_UpdateById() {
        //Arrange
        Drug drug4 = drugRepository.save(new Drug("BOFLOX", 200.00f, 400.00f, 11, 5));
        Long index = drug4.getId();
        //Act
        Drug drug = drugRepository.findById(index)
                .orElse(null);
        assert drug != null;
        drug.setName("MODIFIED");
        Drug updatedDrug = drugRepository.save(drug);
        //Assert
        Assertions.assertThat(updatedDrug.getName()).isEqualTo("MODIFIED");
        Assertions.assertThat(updatedDrug).isNotNull();
        Assertions.assertThat(updatedDrug.getId()).isEqualTo(index);
    }



    @Test
    public void DrugRepositoryFindDrugsAvailable() {
        //Arrange
        //Act
        //Assert
    }

    @Test
    public void DrugRepositoryCountTreatmentsByDrugTypeLastMonth() {
        //Arrange
        //Act
        //Assert
    }

    @Test
    public void DrugRepositoryCalculateTotalSales() {
        //Arrange
        //Act
        //Assert
    }

    @Test
    public void DrugRepositoryFindTop3BestSellingDrugs() {
        //Arrange
        //Act
        //Assert
    }

}
