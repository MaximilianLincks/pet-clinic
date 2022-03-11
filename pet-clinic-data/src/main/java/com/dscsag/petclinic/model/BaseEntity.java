package com.dscsag.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class BaseEntity implements Serializable {
    //Long instead of long (Hibernate recommendation)
    @Getter
    @Setter
    private Long id;
}