package com.dscsag.petclinic.repos;

import com.dscsag.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

import java.awt.image.renderable.ContextualRenderedImageFactory;

public interface PetTypeRepo extends CrudRepository<PetType,Long> {
}
