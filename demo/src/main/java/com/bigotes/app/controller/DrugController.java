package com.bigotes.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bigotes.app.service.DrugService;

@RestController
@RequestMapping("/drug")
@CrossOrigin(origins = "http://localhost:4200")
public class DrugController {
    
    @Autowired
    DrugService petService;

}
