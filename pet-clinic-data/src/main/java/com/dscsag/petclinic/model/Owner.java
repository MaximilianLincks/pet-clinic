package com.dscsag.petclinic.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Owner extends Person{
    private Set<Pet> pets;
    private String address;
    private String city;
    private String telephone;
}
