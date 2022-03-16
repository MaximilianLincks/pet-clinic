package com.dscsag.petclinic.repos;

import com.dscsag.petclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepo extends CrudRepository<Specialty, Long> {
}
