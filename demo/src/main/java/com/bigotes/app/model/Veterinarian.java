package com.bigotes.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Veterinarian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private UserEntity userEntity;

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
    @Size(min = 10,max = 500)
    private String imgUrl;

    @Nonnull
    private String status;

    @JsonIgnore
    @Builder.Default
    @OneToMany(mappedBy = "veterinarian")
    private List<Treatment> treatments = new ArrayList<>();

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
        this.status = "Activo";
    }
}
