package com.dscsag.petclinic.services.springdatajpa.repos;

import com.dscsag.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepo extends CrudRepository<Owner, Long> {
}
