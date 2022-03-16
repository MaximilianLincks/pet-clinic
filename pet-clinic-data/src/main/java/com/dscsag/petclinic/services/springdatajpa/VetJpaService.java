package com.dscsag.petclinic.services.springdatajpa;

import com.dscsag.petclinic.model.Vet;
import com.dscsag.petclinic.services.springdatajpa.repos.VetRepo;
import com.dscsag.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"jpa","default"})
public class VetJpaService extends AbstractJpaService<Vet,Long, VetRepo> implements VetService {

    public VetJpaService(VetRepo vetRepo) {
        super(vetRepo);
    }
}
