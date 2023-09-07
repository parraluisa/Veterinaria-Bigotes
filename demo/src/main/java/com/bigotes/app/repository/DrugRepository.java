package com.bigotes.app.repository;

import com.bigotes.app.model.Drug;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugRepository extends JpaRepository<Drug, Long> {
}
