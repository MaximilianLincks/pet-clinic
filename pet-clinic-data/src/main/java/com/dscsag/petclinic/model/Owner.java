package com.dscsag.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

public class Owner extends Person{

    @Getter
    @Setter
    private Set<Pet> pets;
}
