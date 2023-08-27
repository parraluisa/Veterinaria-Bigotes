package com.bigotes.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Pet {
    private Integer id;
    private Integer idOwner;
    private String imgUrl;
    private String name;
    private String breed;
    private Integer age;
    private Double weight;
    private String disease;
    private LocalDate entry;
    private LocalDate departure;

}
