package com.bigotes.app.repository;

import com.bigotes.app.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findByOwnerId(Long ownerId);

    // Dashboard No. 05
    // Cantidad de mascotas totales en la veterinaria
    @Query("SELECT COUNT(p) FROM Pet p")
    Long countTotalPets();

    // Dashboard No. 06
    // Cantidad de mascotas activas (en tratamiento) en la veterinaria
    @Query("SELECT COUNT(p) FROM Pet p WHERE p.status = 'En tratamiento'")
    Long countActivePets();

    //Todas las mascotas que tengas status en tratamiento
    @Query("SELECT p FROM Pet p WHERE p.status = 'En tratamiento'")
    List<Pet> findPetsInTreatment();

    //Todas las mascotas que tengas status de alta
    @Query("SELECT p FROM Pet p WHERE p.status = 'Alta'")
    List<Pet> findPetsDischarged();

    List<Pet> findByOwnerIdCard(Long idCard);
}
