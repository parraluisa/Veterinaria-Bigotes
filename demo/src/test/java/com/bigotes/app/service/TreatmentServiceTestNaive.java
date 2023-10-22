package com.bigotes.app.service;

import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import com.bigotes.app.model.Drug;
import com.bigotes.app.model.Pet;
import com.bigotes.app.model.Treatment;
import com.bigotes.app.repository.DrugRepository;
import com.bigotes.app.repository.PetRepository;

//Ejecutar una instancia de la aplicación
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ActiveProfiles("test")
public class TreatmentServiceTestNaive {

    @Autowired
    private TreatmentService treatmentService;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private DrugRepository drugRepository;


    @Test
    public void TreatmentService_save_Treatment() {
        // Arrange
        // Crear objeto droga
        LocalDate currentDate = LocalDate.now();
        Drug drug = new Drug(); // Crear un objeto Drug si es necesario

        // Guardar el objeto en la base de datos
        drugRepository.save(drug);
        drug.setItemsAvailable(1);

        Treatment treatment = new Treatment(currentDate, "Tratamiento de prueba1");
        treatment.setDrug(drug); // Asignar la droga al tratamiento

        // Act
        // Guardar el tratamiento
        Treatment newTreatment = treatmentService.save(treatment);

        // Assert
        // Verificar que el tratamiento se haya guardado
        Assertions.assertThat(newTreatment).isNotNull();
    }

    @Test
    public void TreatmentService_findById_Treatment() {
        // Arrange
        // Crear objeto droga
        LocalDate currentDate = LocalDate.now();
        Drug drug = new Drug(); // Crear un objeto Drug si es necesario

        // Guardar el objeto en la base de datos
        drugRepository.save(drug);
        drug.setItemsAvailable(1);

        Treatment treatment = new Treatment(currentDate, "Tratamiento de prueba1");
        treatment.setDrug(drug); // Asignar la droga al tratamiento
        // Guardar el tratamiento
        Treatment newTreatment = treatmentService.save(treatment);

        // Act
        newTreatment = treatmentService.findById(newTreatment.getId());

        // Assert
        // Verificamos que el tratamiento se haya guardado
        Assertions.assertThat(newTreatment).isNotNull();
    }

    @Test
    public void TreatmentService_deleteById_void() {
        // Arrange
        // Crear objeto droga
        LocalDate currentDate = LocalDate.now();
        Drug drug = new Drug(); // Crear un objeto Drug si es necesario

        // Guardar el objeto en la base de datos
        drugRepository.save(drug);
        drug.setItemsAvailable(1);

        Treatment treatment = new Treatment(currentDate, "Tratamiento de prueba1");
        treatment.setDrug(drug); // Asignar la droga al tratamiento

        // Guardamos el tratamiento
        Treatment newTreatment = treatmentService.save(treatment);
        // Act
        // Eliminamos el tratamiento
        treatmentService.deleteById(newTreatment.getId());
        // Assert
        // Verificamos que el tratamiento se haya eliminado
        Assertions.assertThat(treatmentService.findById(newTreatment.getId())).isNull();
    }

    @Test
    public void TreatmentService_findAll_TreatmentList(){
        //Arrange
        LocalDate currentDate = LocalDate.now();
        Drug drug = new Drug(); // Crear un objeto Drug si es necesario

        drugRepository.save(drug);
        drug.setItemsAvailable(5);

        Treatment treatment = new Treatment(currentDate, "Tratamiento de prueba1");
        treatment.setDrug(drug); // Asignar la droga al tratamiento
        Treatment treatment2 = new Treatment(currentDate, "Tratamiento de prueba2");
        treatment2.setDrug(drug); // Asignar la droga al tratamiento
        Treatment newTreatment = treatmentService.save(treatment);
        newTreatment = treatmentService.save(treatment2);

        //Act
        List<Treatment> treatments = treatmentService.findAll();
        //Assert
        Assertions.assertThat(treatments).isNotNull();
        Assertions.assertThat(treatments.size()).isEqualTo(2);
    }

    @Test
    public void TreatmentService_findByPetId_TreatmentList(){
        //Arrange
        LocalDate currentDate = LocalDate.now();
        Pet p = new Pet("Pompita", "British Shorthair", LocalDate.of(2015, 2, 12), 824.65, "Hipotiroidismo", "https://catinaflat.blog/wp-content/uploads/2022/03/british-shorthair-1.jpg");
        Drug drug = new Drug(); // Crear un objeto Drug si es necesario

        petRepository.save(p);
        drugRepository.save(drug);
        drug.setItemsAvailable(5);

        Treatment treatment = new Treatment(currentDate, "Tratamiento de prueba1");
        treatment.setDrug(drug); // Asignar la droga al tratamiento
        treatment.setPet(p);
        Treatment treatment2 = new Treatment(currentDate, "Tratamiento de prueba2");
        treatment2.setDrug(drug); // Asignar la droga al tratamiento
        treatment2.setPet(p);

        Treatment newTreatment = treatmentService.save(treatment);
        newTreatment = treatmentService.save(treatment2);

        //Act
        List<Treatment> treatments = treatmentService.findByPetId(p.getId());

        //Assert
        Assertions.assertThat(treatments).isNotNull();
        Assertions.assertThat(treatments.size()).isEqualTo(2);

    }


    @Test
    public void TreatmentService_countTotalTreatmentForCurrentMonth_Long(){
        //Arrange
        LocalDate currentDate = LocalDate.now();
        Drug drug = new Drug(); // Crear un objeto Drug si es necesario

        drugRepository.save(drug);
        drug.setItemsAvailable(5);

        Treatment treatment = new Treatment(currentDate, "Tratamiento de prueba1");
        treatment.setDrug(drug); // Asignar la droga al tratamiento
        Treatment treatment2 = new Treatment(currentDate, "Tratamiento de prueba2");
        treatment2.setDrug(drug); // Asignar la droga al tratamiento
        Treatment newTreatment = treatmentService.save(treatment);
        newTreatment = treatmentService.save(treatment2);

        //Act
        Long totalTreatments = treatmentService.countTotalTreatmentForCurrentMonth();

        //Assert
        Assertions.assertThat(totalTreatments).isNotNull();
        Assertions.assertThat(totalTreatments).isEqualTo(2L);

    }

}
