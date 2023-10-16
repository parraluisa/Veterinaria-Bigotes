package com.bigotes.app.repository;

import com.bigotes.app.model.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
    List<Treatment> findByPetId(Long petId);

    // Dashboard No. 01
    // Cantidad total de tratamiento administrados en el último mes
    @Query("SELECT COUNT(t) FROM Treatment t WHERE YEAR(t.date) = YEAR(CURDATE()) AND MONTH(t.date) = MONTH(CURDATE())")
    Long countTotalTreatmentForCurrentMonth();

}
