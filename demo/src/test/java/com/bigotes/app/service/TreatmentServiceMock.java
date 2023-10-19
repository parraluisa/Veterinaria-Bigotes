package com.bigotes.app.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import com.bigotes.app.model.Drug;
import com.bigotes.app.model.Pet;
import com.bigotes.app.model.Treatment;
import com.bigotes.app.model.Veterinarian;
import com.bigotes.app.repository.DrugRepository;
import com.bigotes.app.repository.PetRepository;
import com.bigotes.app.repository.TreatmentRepository;
import com.bigotes.app.repository.VeterinarianRepository;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class TreatmentServiceMock {
    @Mock
    private TreatmentRepository treatmentRepository;

    @InjectMocks
    private TreatmentService treatmentService;

    @Mock
    private DrugRepository drugRepository;

    @Mock
    private VeterinarianRepository veterinarianRepository;

    @Mock
    private PetRepository petRepository;

    @BeforeEach
    public void init() {
        // INIT ASOCIADO
        Pet p = new Pet("Pompita", "British Shorthair", LocalDate.of(2015, 2, 12), 824.65, "Hipotiroidismo", "https://catinaflat.blog/wp-content/uploads/2022/03/british-shorthair-1.jpg");
        Veterinarian v = new Veterinarian(1000612796L ,"Andrés", "Garcia", "Montoya", "1234", "Cirujano", "https://images.pexels.com/photos/5327585/pexels-photo-5327585.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");

        petRepository.save(p);
        veterinarianRepository.save(v);
    }

    @Test
    public void TreatmentService_findById_TreatmentFound() {

        // Arrange
        Long treatmentId = 1L;
        Treatment treatment = new Treatment();
        when(treatmentRepository.findById(treatmentId)).thenReturn(Optional.of(treatment));

        // Act
        Treatment foundTreatment = treatmentService.findById(treatmentId);

        // Assert
        Assertions.assertThat(foundTreatment).isNotNull();
    }

    @Test
    public void TreatmentService_findAll_TreatmentList() {

        // Arrange
        List<Treatment> treatmentList = List.of(new Treatment(), new Treatment());
        when(treatmentRepository.findAll()).thenReturn(treatmentList);

        // Act
        List<Treatment> treatments = treatmentService.findAll();

        // Assert
        Assertions.assertThat(treatments).isNotNull();
        Assertions.assertThat(treatments.size()).isEqualTo(2);
    }


    @Test
    public void TreatmentService_save_ValidTreatment() {

        // Arrange
        Treatment treatment = new Treatment();
        Drug drug = new Drug();
        drug.setItemsAvailable(1);
        treatment.setDrug(drug);

        when(treatmentRepository.save(Mockito.any(Treatment.class))).thenReturn(new Treatment());

        // Act
        Treatment savedTreatment = treatmentService.save(treatment);

        // Assert
        Assertions.assertThat(savedTreatment).isNotNull();
    }

    @Test
    public void TreatmentService_save_InvalidTreatment() {

        // Arrange
        Treatment treatment = new Treatment();
        Drug drug = new Drug();
        drug.setItemsAvailable(0);
        treatment.setDrug(drug);        

        // Act
        Treatment savedTreatment = treatmentService.save(treatment);

        // Assert
        Assertions.assertThat(savedTreatment).isNull();
    }

    @Test
    public void TreatmentService_countTotalTreatmentForCurrentMonth() {
        // Arrange
        Long expectedCount = 10L;
        when(treatmentRepository.countTotalTreatmentForCurrentMonth()).thenReturn(expectedCount);

        // Act
        Long count = treatmentService.countTotalTreatmentForCurrentMonth();

        // Assert
        Assertions.assertThat(count).isEqualTo(expectedCount);
    }

    @Test
    public void TreatmentService_deleteById_ValidId() {
        // Arrange
        Long treatmentId = 1L;
        
        // Act
        treatmentService.deleteById(treatmentId);

        // Assert
        verify(treatmentRepository).deleteById(treatmentId);
    }

}
