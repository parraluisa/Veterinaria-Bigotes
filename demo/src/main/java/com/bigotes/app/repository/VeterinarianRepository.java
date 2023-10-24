package com.bigotes.app.repository;

import java.util.List;

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

    //Todos los veterinarios que esten activos
    @Query("SELECT v FROM Veterinarian v WHERE v.status = 'Activo'")
    List<Veterinarian> findAllActiveVeterinarian();

    //Todos los veterinarios que esten inactivos
    @Query("SELECT v FROM Veterinarian v WHERE v.status = 'Inactivo'")
    List<Veterinarian> findAllInactiveVeterinarian();
}
