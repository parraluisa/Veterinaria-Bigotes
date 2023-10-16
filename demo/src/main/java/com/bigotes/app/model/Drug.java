package com.bigotes.app.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import io.micrometer.common.lang.NonNull;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
    private float buyPrice;

    @NonNull
    private float sellPrice;

    @NonNull
    private int itemsAvailable;

    @NonNull
    private int itemsSell;
    @JsonIgnore
    @OneToMany(mappedBy = "drug")
    private List<Treatment> treatments = new ArrayList<>();

    public Drug(){

    }

    public Drug(
            @Nonnull String name,
            @Nonnull float buyPrice,
            @Nonnull float sellPrice,
            @Nonnull int itemsAvailable,
            @Nonnull int itemsSell
    ) {
        this.name = name;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.itemsAvailable = itemsAvailable;
        this.itemsSell = itemsSell;
    }
}
