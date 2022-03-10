package com.dscsag.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class Pet {
    @Getter
    @Setter
    private  PetType petType;
    @Getter
    @Setter
    private Owner owner;
    @Getter
    @Setter
    private LocalDate birthDate;
}
