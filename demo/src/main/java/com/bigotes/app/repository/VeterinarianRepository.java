package com.bigotes.app.repository;

import com.bigotes.app.model.Veterinarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinarianRepository extends JpaRepository<Veterinarian, Long> {
    Veterinarian findByIdCard(Long idCard);
    boolean existsByIdCard(Long idCard);
}
