package com.bigotes.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Owner {

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
    @Column(unique = true)
    private String phone;
    @Nonnull
    @Column(unique = true)
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "owner", cascade = CascadeType.REMOVE)
    private List<Pet> pets = new ArrayList<>();

    public Owner(
            @Nonnull Long idCard,
            @Nonnull String firstName,
            @Nonnull String firstLastName,
            @Nonnull String secondLastName,
            @Nonnull String phone,
            @Nonnull String email
    ) {
        this.idCard = idCard;
        this.firstName = firstName;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.phone = phone;
        this.email = email;
    }
    public Owner orElse(Object object) {
        return null;
    }
}