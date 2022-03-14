package com.dscsag.petclinic.services.map;

import com.dscsag.petclinic.model.Owner;
import com.dscsag.petclinic.services.OwnerService;
import org.springframework.stereotype.Service;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Owner findByLastName(String lastName) {
        return findAll().
                stream().
                filter(owner -> owner.getLastName().equals(lastName)).
                findFirst().
                orElse(null);
    }
}
