package com.dscsag.petclinic.services;

import com.dscsag.petclinic.model.PetType;

public interface PetTypeService extends CrudService<PetType, Long>{

    default PetType findByName(String name){
        return findAll()
                .stream()
                .filter(type -> type.getName().equals(name)).findFirst()
                .orElse(null);
    }

}
