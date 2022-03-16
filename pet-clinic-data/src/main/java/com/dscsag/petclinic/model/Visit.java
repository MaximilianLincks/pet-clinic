package com.dscsag.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Table(name = "visits")
@Entity
public class Visit extends BaseEntity{

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;
}
