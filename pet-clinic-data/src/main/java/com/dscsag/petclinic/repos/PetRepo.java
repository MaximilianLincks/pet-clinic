package com.dscsag.petclinic.repos;

import com.dscsag.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepo extends CrudRepository<Pet,Long> {
}
