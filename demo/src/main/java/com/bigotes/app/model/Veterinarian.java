package com.bigotes.app.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Veterinarian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    @Column(unique = true)
    private Long idCard;

    @Nonnull
    private String firstName;
    @Nonnull
    private String firstLastName;
    @Nonnull
    private String secondLastName;

    @Nonnull
    private String password;

    @Nonnull
    private String speciality;

    @Nonnull
    private String imgUrl;

    @OneToMany(mappedBy = "veterinarian")
    private List<Treatment> treatments = new ArrayList<>();

    public Veterinarian(){

    }

    public Veterinarian(
            @Nonnull Long idCard,
            @Nonnull String firstName,
            @Nonnull String firstLastName,
            @Nonnull String secondLastName,
            @Nonnull String password,
            @Nonnull String speciality,
            @Nonnull String imgUrl
    ) {
        this.idCard = idCard;
        this.firstName = firstName;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.password = password;
        this.speciality = speciality;
        this.imgUrl = imgUrl;
    }
}
