package com.dscsag.petclinic.services.springdatajpa;

import com.dscsag.petclinic.model.Owner;
import com.dscsag.petclinic.repos.OwnerRepo;
import com.dscsag.petclinic.services.OwnerService;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile({"jpa","default"})
public class OwnerJpaService extends AbstractJpaService<Owner,Long, OwnerRepo> implements OwnerService {

    public OwnerJpaService(OwnerRepo ownerRepo) {
        super(ownerRepo);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return repo.findByLastName(lastName);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return repo.findAllByLastNameLike(lastName);
    }
}
