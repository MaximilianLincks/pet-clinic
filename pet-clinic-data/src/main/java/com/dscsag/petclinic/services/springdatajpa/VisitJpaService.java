package com.dscsag.petclinic.services.springdatajpa;

import com.dscsag.petclinic.model.Visit;
import com.dscsag.petclinic.repos.VisitRepo;
import com.dscsag.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"jpa","default"})
public class VisitJpaService extends AbstractJpaService<Visit, Long, VisitRepo> implements VisitService {

    public VisitJpaService(VisitRepo visitRepo) {
        super(visitRepo);
    }
}
