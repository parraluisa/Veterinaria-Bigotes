package com.bigotes.app.repository;

import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.cglib.core.Local;

import com.bigotes.app.model.Drug;
import com.bigotes.app.model.Treatment;

@DataJpaTest
public class TreatmentRepositoryTest {
    @Autowired
    private TreatmentRepository treatmentRepository;

    @Autowired
    private DrugRepository drugRepository;
    
    @BeforeEach
    void init(){
        //Create drug 1
        Drug drug1 = drugRepository.save(new Drug("Paracetamol", 50, 100, 50, 1));

        //Create treatment 1
        LocalDate currentDate = LocalDate.now();
        Treatment treatment1 = new Treatment(currentDate, "Tratamiento de prueba1");
        treatment1.setDrug(drug1); // Asignar la droga al tratamiento
        
        //Create treatment 2
        Treatment treatment2 = new Treatment(currentDate, "Tratamiento de prueba2");
        treatment2.setDrug(drug1); // Asignar la droga al tratamiento

        //Create treatment 3
        Treatment treatment3 = new Treatment(currentDate, "Tratamiento de prueba3");
        treatment3.setDrug(drug1); // Asignar la droga al tratamiento

        treatment1 = treatmentRepository.save(treatment1);
        treatment2 = treatmentRepository.save(treatment2);
        treatment3 = treatmentRepository.save(treatment3);

    }

    @Test
    public void TreatmentRepository_countTotalTreatmentForCurrentMonth_Long(){
        //Arrange
        //Act
        Long totalTreatmentForCurrentMonth = treatmentRepository.countTotalTreatmentForCurrentMonth();
        //Assert
        Assertions.assertThat(totalTreatmentForCurrentMonth).isNotNull();
        Assertions.assertThat(totalTreatmentForCurrentMonth).isEqualTo(3);
    }
    
}
