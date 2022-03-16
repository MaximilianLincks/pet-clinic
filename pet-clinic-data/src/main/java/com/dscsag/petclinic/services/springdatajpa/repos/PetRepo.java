package com.dscsag.petclinic.services.springdatajpa.repos;

import com.dscsag.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepo extends CrudRepository<Pet,Long> {
}
