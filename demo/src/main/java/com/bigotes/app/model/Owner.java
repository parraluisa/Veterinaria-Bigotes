package com.bigotes.app.model;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Owner {
    private Integer id;
    private Integer idCard;
    private String password;
    private String name;
    private String firstLastName;
    private String secondLastName;
    private String phone;
    private String email;
    private ArrayList<Pet> pets;
}
