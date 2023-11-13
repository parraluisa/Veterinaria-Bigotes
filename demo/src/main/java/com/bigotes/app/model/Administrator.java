package com.bigotes.app.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private UserEntity userEntity;

    @Nonnull
    @Column(unique = true)
    private Long idCard;

    @Nonnull
    private String password;

    public Administrator(@Nonnull Long idCard, @Nonnull String password) {
        this.idCard = idCard;
        this.password = password;
    }
}
