package com.dscsag.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "specialty")
@Entity
public class Specialty extends  BaseEntity{

    @Column(name = "description")
    private String description;
}
