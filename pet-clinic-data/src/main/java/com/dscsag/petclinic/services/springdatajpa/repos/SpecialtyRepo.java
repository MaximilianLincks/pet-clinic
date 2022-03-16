package com.dscsag.petclinic.services.springdatajpa.repos;

import com.dscsag.petclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepo extends CrudRepository<Specialty, Long> {
}
