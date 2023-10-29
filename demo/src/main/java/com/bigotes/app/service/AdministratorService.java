package com.bigotes.app.service;

import com.bigotes.app.model.Administrator;
import com.bigotes.app.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorService {
    @Autowired
    private AdministratorRepository repository;

    public Administrator findByIcCard(Long idCard){
        return repository.findByIdCard(idCard);
    }
}
