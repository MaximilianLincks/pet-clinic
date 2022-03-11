package com.dscsag.petclinic.services.map;

import com.dscsag.petclinic.model.Vet;

public class VetMapService extends AbstractMapService<Vet,Long>{
    @Override
    public Vet save(Vet vet) {
        return super.save(vet.getId(), vet);
    }
}
