package com.example.demo.entidad;

import java.time.LocalDate;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Pet {
    private String name;
    private String breed;
    private int age;
     private double weight;
    private String disease;
    private LocalDate entry;
    private LocalDate departure;
}
