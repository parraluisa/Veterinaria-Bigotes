package com.bigotes.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Treatment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    private LocalDate date;

    private String description;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "drug_id")
    private Drug drug;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "veterinarian_id")
    private Veterinarian veterinarian;

    public Treatment() {

    }

    public Treatment( @Nonnull LocalDate date, @Nonnull String description) {
        this.date = date;
        this.description = description;
    }
}
