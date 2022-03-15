package com.dscsag.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class Visit extends BaseEntity{
    @Getter
    @Setter
    private LocalDate date;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private Pet pet;
}
