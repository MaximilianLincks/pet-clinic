package com.dscsag.petclinic.repos;

import com.dscsag.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepo extends CrudRepository<Visit, Long> {
}
