package com.bigotes.app.repository;

import com.bigotes.app.model.Drug;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugRepository extends JpaRepository<Drug, Long> {

    // Dashboard No. 02
    // Cantidad de tratamientos por tipo de medicamento administrado 
    // en el último mes (tabla medicamento - cantidad)
    @Query("SELECT d.name, COUNT(t) " +
           "FROM Drug d " +
           "LEFT JOIN d.treatments t " +
           "WHERE FUNCTION('YEAR', t.date) = FUNCTION('YEAR', CURRENT_DATE) " +
           "AND FUNCTION('MONTH', t.date) = FUNCTION('MONTH', CURRENT_DATE) " +
           "GROUP BY d.name")
    List<Object[]> countTreatmentsByDrugTypeLastMonth();

    // Dashboard No. 07
    // Ventas totales de la veterinaria
    @Query("SELECT SUM(d.sellPrice * d.itemsSell) FROM Drug d")
    Float calculateTotalSales();

    // Dashboard No. 08
    // Ganancias totales de la veterinaria
    @Query("SELECT SUM((d.sellPrice * d.itemsSell) - (d.buyPrice * d.itemsAvailable)) FROM Drug d")
    Float calculateTotalProfits();
}
