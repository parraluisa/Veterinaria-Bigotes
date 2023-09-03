package com.bigotes.app.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

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
    private Date birthday;
    @Nonnull
    private Double weight;

    private String disease;
    @Nonnull
    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public Pet(
            @Nonnull String name,
            @Nonnull String breed,
            @Nonnull Date birthday,
            @Nonnull Double weight,
            String disease,
            @Nonnull String imgUrl)
    {
        this.name = name;
        this.breed = breed;
        this.birthday = birthday;
        this.weight = weight;
        this.disease = disease;
        this.imgUrl = imgUrl;
    }

    public Pet() {

    }

    public int calculateAge() {
        LocalDate birthDate = birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthDate, currentDate);
        return period.getYears();
    }
}
