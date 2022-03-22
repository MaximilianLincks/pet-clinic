package com.dscsag.petclinic.services;

import com.dscsag.petclinic.model.Owner;
import com.dscsag.petclinic.model.Pet;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public interface PetService extends CrudService<Pet,Long>{
    default List<Pet> findPetsOfOwnerByName(String petName, Owner owner){
        if (owner == null) return List.of();
        return findAll().stream()
                .filter(pet -> Objects.equals(pet.getOwner().getId(), owner.getId()))
                .filter(pet -> pet.getName().equals(petName))
                .collect(Collectors.toList());
    }
}
