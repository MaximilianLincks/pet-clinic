package com.dscsag.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class BaseEntity implements Serializable {
    //Long instead of long (Hibernate recommendation)

    private Long id;
}
