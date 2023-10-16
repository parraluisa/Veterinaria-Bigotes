package com.bigotes.app.repository;

import com.bigotes.app.model.Veterinarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinarianRepository extends JpaRepository<Veterinarian, Long> {
    Veterinarian findByIdCard(Long idCard);
    boolean existsByIdCard(Long idCard);

    // Dashboard No. 03
    // Cantidad de veterinarios activos en la plataforma
    @Query("SELECT COUNT(v) FROM Veterinarian v WHERE v.status = 'Activo'")
    Long countActiveVeterinarians();

    // Dashboard No. 04
    //Cantidad de veterinarios inactivos en la plataforma
    @Query("SELECT COUNT(v) FROM Veterinarian v WHERE v.status = 'Inactivo'")
    Long countInactiveVeterinarians();
}
