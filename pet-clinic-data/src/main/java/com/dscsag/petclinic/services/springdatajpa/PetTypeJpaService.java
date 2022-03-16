package com.dscsag.petclinic.services.springdatajpa;

import com.dscsag.petclinic.model.PetType;
import com.dscsag.petclinic.repos.PetTypeRepo;
import com.dscsag.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"jpa","default"})
public class PetTypeJpaService extends AbstractJpaService<PetType,Long, PetTypeRepo> implements PetTypeService {

    public PetTypeJpaService(PetTypeRepo petTypeRepo) {
        super(petTypeRepo);
    }
}
