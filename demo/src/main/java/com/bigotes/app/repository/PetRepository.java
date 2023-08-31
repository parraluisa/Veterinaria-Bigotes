package com.bigotes.app.repository;

import com.bigotes.app.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    Collection<Pet> findByOwnerId(Long ownerId);
}
