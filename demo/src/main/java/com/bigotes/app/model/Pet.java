package com.bigotes.app.model;

import java.time.LocalDate;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Pet {
    private Integer id;
    private String imgUrl;
    private String name;
    private String breed;
    private int age;
    private double weight;
    private String disease;
    private LocalDate entry;
    private LocalDate departure;

}
