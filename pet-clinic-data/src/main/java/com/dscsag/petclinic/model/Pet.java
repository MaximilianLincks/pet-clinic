package com.dscsag.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "pet_type")
    private PetType petType;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    //i dont think you should cascade here
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "name")
    private String name;


}
