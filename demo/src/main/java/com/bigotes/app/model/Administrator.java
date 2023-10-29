package com.bigotes.app.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    @Column(unique = true)
    private Long idCard;

    @Nonnull
    private String password;

    Administrator(){}

    public Administrator(@Nonnull Long idCard, @Nonnull String password) {
        this.idCard = idCard;
        this.password = password;
    }
}
