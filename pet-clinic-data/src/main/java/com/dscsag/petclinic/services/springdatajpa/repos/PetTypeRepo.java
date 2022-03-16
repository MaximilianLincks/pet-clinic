package com.dscsag.petclinic.services.springdatajpa.repos;

import com.dscsag.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;


public interface PetTypeRepo extends CrudRepository<PetType, Long> {
}
