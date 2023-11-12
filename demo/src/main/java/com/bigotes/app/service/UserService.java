package com.bigotes.app.service;

import com.bigotes.app.model.UserEntity;
import com.bigotes.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements CrudService<UserEntity, Long> {
    @Autowired
    UserRepository userRepository;


    @Override
    public UserEntity findById(Long aLong) {
        return userRepository.findById(aLong).orElse(null);
    }

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(Long aLong) {
        userRepository.deleteById(aLong);
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public boolean existsByUsername(Long idCard) {
        return userRepository.existsByUsername(idCard);
    }

    public UserEntity findByUsername(Long username) {
        return userRepository.findByUsername(username).orElse(null);
    }
}
