package com.dscsag.petclinic.repos;

import com.dscsag.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepo extends CrudRepository<Owner, Long> {
}
