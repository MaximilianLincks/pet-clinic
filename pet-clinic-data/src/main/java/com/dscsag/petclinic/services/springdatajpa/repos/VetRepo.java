package com.dscsag.petclinic.services.springdatajpa.repos;

import com.dscsag.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepo extends CrudRepository<Vet,Long> {
}
