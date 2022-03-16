package com.dscsag.petclinic.services.springdatajpa;

import com.dscsag.petclinic.model.Owner;
import com.dscsag.petclinic.repos.OwnerRepo;
import com.dscsag.petclinic.services.OwnerService;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class OwnerJpaService extends AbstractJpaService<Owner,Long, OwnerRepo> implements OwnerService {

    public OwnerJpaService(OwnerRepo ownerRepo) {
        super(ownerRepo);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return findAll().stream().filter(owner -> owner.getLastName().equals(lastName)).findFirst().orElse(null);
    }
}
