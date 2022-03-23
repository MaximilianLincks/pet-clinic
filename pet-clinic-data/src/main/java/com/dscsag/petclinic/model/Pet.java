package com.dscsag.petclinic.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "pet_type")
    @NotNull
    private PetType petType;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    //i dont think you should cascade here
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    @Builder.Default
    private Set<Visit> visits = new HashSet<>();

    @Column(name = "birth_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    @PastOrPresent
    private LocalDate birthDate;

    @Column(name = "name")
    @NotBlank
    private String name;

    @Override
    public String toString() {
        return String.format("%s: %s",name,petType == null ? "" : petType.getName());
    }
}
