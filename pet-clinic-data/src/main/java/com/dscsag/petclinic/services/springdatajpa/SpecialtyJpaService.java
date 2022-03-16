package com.dscsag.petclinic.services.springdatajpa;

import com.dscsag.petclinic.model.Specialty;
import com.dscsag.petclinic.repos.SpecialtyRepo;
import com.dscsag.petclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class SpecialtyJpaService extends AbstractJpaService<Specialty,Long, SpecialtyRepo> implements SpecialtyService {

    public SpecialtyJpaService(SpecialtyRepo specialtyRepo) {
        super(specialtyRepo);
    }
}
