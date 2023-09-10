package com.bigotes.app.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Drug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    @Column(unique = true)
    private String name;

    @Nonnull
    private Double price;

    @OneToMany(mappedBy = "drug")
    private List<Treatment> treatments = new ArrayList<>();

    public Drug(){

    }

    public Drug(
            @Nonnull String name,
            @Nonnull Double price
    ) {
        this.name = name;
        this.price = price;
    }
}
