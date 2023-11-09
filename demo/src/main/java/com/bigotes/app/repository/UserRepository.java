package com.bigotes.app.repository;

import com.bigotes.app.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(Long username);
    Boolean existsByUsername(Long username);
}
