package com.bigotes.app.DTOs;

import java.time.LocalDate;

import com.bigotes.app.model.Owner;

import lombok.Data;

@Data
public class PetDTO {
    private Long id;
    private String name;
    private String breed;
    private LocalDate birthdate;
    private Double weight;
    private String disease;
    private String imgUrl;
    private String status;
    private Owner owner;
    
}
