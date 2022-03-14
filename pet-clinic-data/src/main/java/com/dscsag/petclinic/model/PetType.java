package com.dscsag.petclinic.model;

import lombok.Getter;
import lombok.Setter;

public class PetType extends BaseEntity<Long>{
    @Getter
    @Setter
    private String name;
}
