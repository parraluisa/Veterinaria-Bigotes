package com.bigotes.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bigotes.app.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(Long username);
    Boolean existsByUsername(Long username);
}
