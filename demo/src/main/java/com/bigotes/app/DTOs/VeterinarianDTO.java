package com.bigotes.app.DTOs;

import java.time.LocalDate;

import lombok.Data;

@Data
public class VeterinarianDTO {
    private Long id;
    private Long idCard;
    private String firstName;
    private String firstLastName;
    private String secondLastName;
    private String speciality;
    private String imgUrl;
    private String status;
    private LocalDate entryDate;
}
