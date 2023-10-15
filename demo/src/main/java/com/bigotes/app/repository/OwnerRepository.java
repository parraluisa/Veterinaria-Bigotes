package com.bigotes.app.repository;

import com.bigotes.app.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    Owner findByIdCard(Long idCard);
    Owner findOwnerByPets_Id(Long petId);
    boolean existsByIdCard(Long idCard);
}
