package com.bigotes.app.repository;

import com.bigotes.app.model.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrugRepository extends JpaRepository<Drug, Long> {

    @Query("SELECT d FROM Drug d WHERE d.itemsAvailable > 0")
    List<Drug> findDrugsAvailabale();

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
    @Query("SELECT SUM(((d.sellPrice - d.buyPrice) * d.itemsSell)) FROM Drug d")
    Float calculateTotalProfits();

    // Dashboard No. 09
    // Top 3 medicamentos con más unidades vendidas
    @Query("SELECT d, SUM(d.itemsSell) AS totalUnitsSold " +
    "FROM Drug d " +
    "GROUP BY d " +
    "ORDER BY totalUnitsSold DESC LIMIT 3")
    List<Object[]> findTop3BestSellingDrugs();
}
