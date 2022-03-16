package com.dscsag.petclinic.services.springdatajpa.repos;

import com.dscsag.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepo extends CrudRepository<Visit, Long> {
}
