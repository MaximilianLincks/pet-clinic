package com.dscsag.petclinic.services.springdatajpa;

import com.dscsag.petclinic.model.Owner;
import com.dscsag.petclinic.model.Pet;
import com.dscsag.petclinic.repos.PetRepo;
import com.dscsag.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile({"jpa","default"})
public class PetJpaService extends AbstractJpaService<Pet,Long, PetRepo> implements PetService {

    public PetJpaService(PetRepo petRepo) {
        super(petRepo);
    }

    @Override
    public List<Pet> findPetsOfOwnerByName(String petName, Owner owner) {
        if (owner == null) return List.of();
        return repo.findPetsOfOwnerByName(petName,owner.getId());
    }
}
