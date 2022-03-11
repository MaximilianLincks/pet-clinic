package com.dscsag.petclinic.services.map;

import com.dscsag.petclinic.model.Owner;

public class OwnerMapService extends AbstractMapService<Owner, Long>  {

    @Override
    public Owner save(Owner owner) {
        return super.save(owner.getId(),owner);
    }
}
