package com.bigotes.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    private String name;
    @Nonnull
    private String breed;
    @Nonnull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;
    @Nonnull
    private Double weight;

    private String disease;

    @Nonnull
    @Size(min = 10,max = 500)
    private String imgUrl;

    @Nonnull
    private String status;


    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @JsonIgnore
    @OneToMany(mappedBy = "pet")
    private List<Treatment> treatments = new ArrayList<>();

    public Pet(
            @Nonnull String name,
            @Nonnull String breed,
            @Nonnull LocalDate birthdate,
            @Nonnull Double weight,
            String disease,
            @Nonnull String imgUrl)
    {
        this.name = name;
        this.breed = breed;
        this.birthdate = birthdate;
        this.weight = weight;
        this.disease = disease;
        this.imgUrl = imgUrl;
        if (disease.equals("Ninguna"))
            this.status = "Alta médica";
        else
            this.status = "En tratamiento";
    }

    public Pet() {

    }

    public int calculateAge() {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(this.birthdate, currentDate);
        return period.getYears();
    }
}
