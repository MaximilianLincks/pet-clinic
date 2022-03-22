package com.dscsag.petclinic.repos;

import com.dscsag.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;


public interface PetTypeRepo extends CrudRepository<PetType, Long> {
    PetType findByNameIgnoreCase(String name);
}
